package lab.rest.core;

import java.util.Map;

public interface Poster {
    public String post(String endpoint, String jsonRequestBody,Map<String,String> headers);
    public String get(String endpoint, Map<String,String> headers );
    public String put(String endpoint, String jsonRequestBody, Map<String,String> headers);



}
