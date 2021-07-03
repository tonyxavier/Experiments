package lab.rest.app;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import lab.rest.impl.Post;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FulFil {

    private static final String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjI1MTM3MWJkZWQzOTBmZjM4MjE5MmViN2MwM2VmMzdmODBiYmVkODA4MmJmNzdiODdmZDFkODVmYjZjYWFkMzgzZDU4OTQ1NWJkZjVjMjEyIn0.eyJhdWQiOiIyOGI3NmRhMC04NmI2LTExZTktYjhiMy01NzA5YTk0ZDE0YmQiLCJqdGkiOiIyNTEzNzFiZGVkMzkwZmYzODIxOTJlYjdjMDNlZjM3ZjgwYmJlZDgwODJiZjc3Yjg3ZmQxZDg1ZmI2Y2FhZDM4M2Q1ODk0NTViZGY1YzIxMiIsImlhdCI6MTYxOTQ2NDY2NSwibmJmIjoxNjE5NDY0NjY1LCJleHAiOjE2MTk0NjY0NjUsInN1YiI6IiIsInNjb3BlcyI6WyJmZm4uZnVsZmlsbGVyLnJlYWQiLCJmZm4uZnVsZmlsbGVyLndyaXRlIl19.mYk6Lhi03BzyTASmp_9QvnScv8ccw8KKFGVDl2pVWL2gBOeJfX6PmMN-9UAcnl2_nmzsBDLt0dQGsBwRgrYEgZ4AF189z9AG35defrzHmwgUEqvLClrtwA8VCJ44-q2AoUIbyMmRgdriBCc7KQEgW7phNZo5egqXzoKO-KUwFkxYGybLmmS-8k0Q-2A2yY8RN--bJvHdX4-O0zNddL5uId0yCFFV7TB3dSTxrSg56PSxRlSRgtCrLUa-gNqp8buBOT2QvE_ygeR8Uws6Ay4TqnHN925CImFzqojAZlEWtJYIxcoqUxOZte5xEICse5UdqXPbVmuYvgCSKv_dqWVKWRVwewwuYoEc5b5RGSYXoncB8Y9KovdKzsqQfpYHrHQHFstZw9_vHELMuSiNRFTiKaxM3EzhpemOZUvlcGkoXJyUUBDm8Sidw3qTWHdslApHAZxmfyfpeEJsBQMtUcJkiBYvUPYl0We-_m0VaUE923c1IpFC9d-FphB-m4pRV2w545zpAGa5NXvxURD_1mb5cg3lQbx2I4pbK7ShWbvtlJqKoJdfs5JgZzHUlKujrzUYs9uJv5rbTXxfgw4B1Ql40MOw_vEUFH52vSi1IZCYbRD-Xq-r04PBVPuOEnqpll1Nd8pfsP9bGbqzQda93SB1NF2X-wNpXNLengYheiZBrjk";

    public static void main(String[] args) {

        List<String> skus = loadFile();

        for (String sku:skus){
            System.out.println("SKU:"+sku);

            String stockResponse = getStock(sku);

            System.out.println(stockResponse);

            int quantity=stockLevel(stockResponse);
            if(quantity==0){
                System.out.println("Skipping:"+sku);
                continue;
            }


            List<String> outbounds = getPendingOutbounds(stockResponse);

            for (String outbound:outbounds) {
                System.out.println("   OB:" + outbound);
                changeOrderStatus(outbound,"Acknowledged");
                changeOrderStatus(outbound,"Canceled");

            }

            postAdjustment(sku,quantity);


        }

        // postAdjustment();

        //changeOrderStatus("UG2902AH3","Acknowledged");
        //  changeOrderStatus("UG2902AH3","Canceled");


    }

    private static int stockLevel(String stock){

        try {

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(stock);
            double quantity = (Double) json.get("stockLevel");
            int q=(int)quantity;
            System.out.println("Quantity:"+q);
            return q;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return -1;

    }

    private static List<String> getPendingOutbounds(String stockResponse){

        ArrayList<String> outbounds =new ArrayList<>();
        try {

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(stockResponse);
            JSONArray stockReservedDetails =(JSONArray)  json.get("stockReservedDetails");
            for(int i=0;i<stockReservedDetails.size();i++){

                JSONObject reserves = (JSONObject)stockReservedDetails.get(i);
                outbounds.add((String) reserves.get("outboundId"));


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return outbounds;

    }



    public static void changeOrderStatus(String outboundId, String status){


        Post rest = new Post();
        String endpoint="https://ffn2.api.jtl-software.com/api/v1/fulfiller/outbounds/"+outboundId+"/status";
        String jsonInputString = buildChangeOrderStatusRequest(status);
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        headers.put("Content-Type","application/json; utf-8");
        headers.put("Accept", "application/json");

        String result = rest.put(endpoint,jsonInputString,headers);
        System.out.println(result);

    }



    public static String getStock(String sku){

        Post rest = new Post();
        String endpoint="https://ffn2.api.jtl-software.com/api/v1/fulfiller/stocks/"+sku;
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        headers.put("Content-Type","application/json; utf-8");
        headers.put("Accept", "application/json");

        String result = rest.get(endpoint,headers);
        return result;



    }

    public static void postAdjustment(String sku,int quantity){

        Post rest = new Post();
        String endpoint="https://ffn2.api.jtl-software.com/api/v1/fulfiller/stocks/adjustments";
        String jsonInputString = buildRequestBody(sku,quantity);
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Authorization",token);
        headers.put("Content-Type","application/json; utf-8");
        headers.put("Accept", "application/json");

        String result = rest.post(endpoint,jsonInputString,headers);
        System.out.println(result);


    }


    public String get(String endpoint, Map<String,String> headers ) {

        try {
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            for(String key:headers.keySet()) {
                con.setRequestProperty(key, headers.get(key));
            }
            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);

            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public String put(String endpoint, String jsonRequestBody, Map<String,String> headers){

        try {

            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("PUT");

            for(String key : headers.keySet()) {
                con.setRequestProperty(key, headers.get(key));
            }

            con.setDoOutput(true);
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonRequestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                con.disconnect();
                return response.toString();
            }


        }catch (MalformedURLException mfue) {
            mfue.printStackTrace();

        }
        catch (ProtocolException pe) {
            pe.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }


        return null;
    }





    public String post(String endpoint, String jsonRequestBody, Map<String,String> headers){

        try {

            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            for(String key : headers.keySet()) {
                con.setRequestProperty(key, headers.get(key));
            }

            con.setDoOutput(true);
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonRequestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                con.disconnect();
                return response.toString();
            }


        }catch (MalformedURLException mfue) {
            mfue.printStackTrace();

        }
        catch (ProtocolException pe) {
            pe.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }


        return null;
    }

    private static String getTimeStamp(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(new Date());

    }


    private static String buildRequestBody(String sku,int quantity){

        JSONObject obj = new JSONObject();

        obj.put("jfsku", sku);
        obj.put("warehouseId", "2NVY04DE-99192-0001");
        obj.put("quantity", quantity*-1);
        obj.put("fulfillerTimestamp", getTimeStamp());

        String req=obj.toJSONString();
        return req;

    }

    private static String buildChangeOrderStatusRequest(String status){


        JSONObject obj = new JSONObject();

        obj.put("status", status);


        String req=obj.toJSONString();
        return req;

    }




    private static List<String> loadFile(){

        ArrayList<String> skus=null;
        try
        {
            File file=new File("skus.csv");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            skus = new ArrayList<>();
            String line;
            while((line=br.readLine())!=null)
            {
                skus.add(line);

            }
            fr.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return skus;

    }



}


