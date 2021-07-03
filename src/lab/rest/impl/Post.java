package lab.rest.impl;

import lab.rest.core.Poster;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;

public class Post implements Poster{


public String get(String endpoint, Map<String,String> headers ) {

    try {
        URL url = new URL(endpoint);
        System.out.println(endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        if(headers==null)
            headers=new HashMap<String,String>();
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



    }


