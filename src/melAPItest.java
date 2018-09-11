import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class melAPItest {
    private static String API_SERVER = "https://stage-public.provisioning-api.melbourneit.com.au/v1/vaps/order";
    private static String API_CREDENTIAL = "test:testpassword";
    private static String CREATE_ORDER = "POST";
    private static String DELETE_ORDER = "DELETE";
    private static String GET_ORDER = "GET";

    public static void ignoreName() {
       HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
           public boolean verify(String hostname,
                                 javax.net.ssl.SSLSession sslSession) {
               if (hostname.equals("stage-public.provisioning-api.melbourneit.com.au")) {
                   return true;
               }
               return false;
           }
       });
    }

    /*public static String convertToJson(HashMap<String, String> passedInParams) throws JSONException {
        JSONObject result = new JSONObject();
        JSONObject provisionData = new JSONObject();
        JSONObject customerData = new JSONObject();
        JSONObject productProvisionData = new JSONObject();
        JSONObject provisionConfig = new JSONObject();

        //customer data
        customerData.put("lastName",passedInParams.get("lastName"));
        customerData.put("fax",passedInParams.get("fax"));
        customerData.put("state",passedInParams.get("state"));
        customerData.put("postCode",passedInParams.get("postCode"));
        customerData.put("addressLine2",passedInParams.get("addressLine2"));
        customerData.put("addressLine1",passedInParams.get("addressLine1"));
        customerData.put("city",passedInParams.get("city"));
        customerData.put("countryCode",passedInParams.get("countryCode"));
        customerData.put("phoneNumber",passedInParams.get("phoneNumber"));
        customerData.put("email",passedInParams.get("email"));
        customerData.put("company",passedInParams.get("company"));
        customerData.put("province",passedInParams.get("province"));
        customerData.put("firstName",passedInParams.get("firstName"));

        //product data
        productProvisionData.put("businessCategory",passedInParams.get("businessCategory"));
        provisionConfig.put("hostingUsername",passedInParams.get("hostingUsername"));
        provisionConfig.put("hostingPassword",passedInParams.get("hostingPassword"));
        provisionConfig.put("hostingURL",passedInParams.get("hostingURL"));
        provisionConfig.put("emailUsername",passedInParams.get("emailUsername"));
        provisionConfig.put("emailPassword",passedInParams.get("emailPassword"));
        productProvisionData.put("provisionConfig",provisionConfig);
        provisionData.put("domainName",passedInParams.get("domainName"));
        provisionData.put("customerData",customerData);
        provisionData.put("productProvisionData",productProvisionData);

        //generate result json
        result.put("productCode",passedInParams.get("productCode"));
        result.put("resellerUsername",passedInParams.get("resellerUsername"));
        result.put("provisionData", provisionData);

        return result.toString();
    }
*/
    public static String convertToJson(HashMap<String, String> passedInParams) throws JSONException {
        JSONObject result = new JSONObject();
        JSONObject provisionData = new JSONObject();
        JSONObject customerData = new JSONObject();
        JSONObject productProvisionData = new JSONObject();
        JSONObject provisionConfig = new JSONObject();

        //customer data
        customerData.put("lastName",passedInParams.get("lastName"));
        customerData.put("fax",passedInParams.get("fax"));
        customerData.put("state",passedInParams.get("state"));
        customerData.put("postCode",passedInParams.get("postCode"));
        customerData.put("addressLine2",passedInParams.get("addressLine2"));
        customerData.put("addressLine1",passedInParams.get("addressLine1"));
        customerData.put("city",passedInParams.get("city"));
        customerData.put("countryCode",passedInParams.get("countryCode"));
        customerData.put("phoneNumber",passedInParams.get("phoneNumber"));
        customerData.put("email",passedInParams.get("email"));
        customerData.put("company",passedInParams.get("company"));
        customerData.put("province",passedInParams.get("province"));
        customerData.put("firstName",passedInParams.get("firstName"));

        //product data
        productProvisionData.put("businessCategory",passedInParams.get("businessCategory"));
        productProvisionData.put("brandName","");
        productProvisionData.put("salesPersonName","");
        productProvisionData.put("salesPersonEmail","");

        provisionConfig.put("hostingUsername",passedInParams.get("hostingUsername"));
        provisionConfig.put("hostingPassword",passedInParams.get("hostingPassword"));
        provisionConfig.put("hostingURL",passedInParams.get("hostingURL"));
        provisionConfig.put("emailUsername",passedInParams.get("emailUsername"));
        provisionConfig.put("emailPassword",passedInParams.get("emailPassword"));
        productProvisionData.put("provisionConfig",provisionConfig);
        provisionData.put("domainName",passedInParams.get("domainName"));
        provisionData.put("customerData",customerData);
        provisionData.put("productProvisionData",productProvisionData);


        //generate result json
        result.put("productCode",passedInParams.get("productCode"));
        result.put("resellerUsername",passedInParams.get("resellerUsername"));
        result.put("provisionData", provisionData);


        return result.toString();
    }

    public static String getCreatedOrderId(String response) throws JSONException {
        JSONObject jsonResult= new JSONObject(response);
        return jsonResult.getJSONObject("order").get("orderId").toString();
    }


    public static String createOrderInfo() {
        try {
            String result = "";
            HashMap<String, String> passedInParams = new HashMap<String, String>();
            String API_URL = API_SERVER;
            passedInParams.put("url", API_URL);
            passedInParams.put("method", CREATE_ORDER);
            passedInParams.put("lastName","asdfasdf");

            //customer data
            passedInParams.put("fax","");
            passedInParams.put("state","NSW");
            passedInParams.put("postCode","2200");
            passedInParams.put("addressLine2","");
            passedInParams.put("addressLine1","line1");
            passedInParams.put("city","sydney");
            passedInParams.put("countryCode","AU");
            passedInParams.put("phoneNumber","+61400022");
            passedInParams.put("email","sdfsd@netregistry.com.au");
            passedInParams.put("company","NRG");
            passedInParams.put("province","");
            passedInParams.put("firstName","testFName");

            //product data
            passedInParams.put("businessCategory","Communications & IT");
            passedInParams.put("hostingUsername","");
            passedInParams.put("hostingPassword","");
            passedInParams.put("hostingURL","");
            passedInParams.put("emailUsername","");
            passedInParams.put("emailPassword","");
            passedInParams.put("domainName","testdomain.com");
            passedInParams.put("productCode","SPOTDIFM1STM");
            passedInParams.put("resellerUsername","");

            result = call(passedInParams);

            return result + "\n" + "orderID: " + getCreatedOrderId(result);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getOrderInfo(String id) {
        try {
            HashMap<String, String> passedInParams = new HashMap<String, String>();
            String API_URL = API_SERVER + "/"+id;
            passedInParams.put("url", API_URL);
            passedInParams.put("method", GET_ORDER);
            return call(passedInParams);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String deleteOrderInfo (String id) {
        try {
            HashMap<String, String> passedInParams = new HashMap<String, String>();
            String API_URL = API_SERVER + "/"+id;
            passedInParams.put("url", API_URL);
            passedInParams.put("method", DELETE_ORDER);
            return call(passedInParams);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String call(HashMap<String, String> passedInParams) {
        try {
            String response = "";
            ignoreName();
            URL url = new URL(passedInParams.get("url"));
            String encoding = Base64.encodeBase64String(API_CREDENTIAL.getBytes("utf-8"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod(passedInParams.get("method"));
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setDoOutput(true);

            if(CREATE_ORDER.equals(passedInParams.get("method"))){
                String JsonRequest = convertToJson(passedInParams);

                OutputStream os = connection.getOutputStream();
                os.write(JsonRequest.getBytes());
                os.flush();
                os.close();
            }

            if (connection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED || connection.getResponseCode() == HttpURLConnection.HTTP_OK
                    || connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                response = responseToString(in);
                connection.disconnect();
                return response;
            }else{
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                response = responseToString(in);
                connection.disconnect();
                throw new Exception(response);
            }
            /*}else {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                response = responseToString(in);
                connection.disconnect();
                throw new Exception(response);
            }*/

        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String responseToString(BufferedReader in) throws IOException {
        String response ="",line="";
        while ((line = in.readLine()) != null) {
            response += line + "\n";
        }
        return response;
    }

    public static void main(String[] args) throws JSONException {

        String result = "",orderId ="367722";
       /* System.out.println("get order " + orderId);
        result = getOrderInfo(orderId);
        System.out.println(result);*/

        System.out.println("deleteing order " + orderId);
        result = deleteOrderInfo(orderId);
        System.out.println(result);

/*      System.out.println("get order " + orderId);
        result = getOrderInfo(orderId);
        System.out.println(result);
/*
        System.out.println("create new order");
        result = createOrderInfo();
        System.out.println(result);*/

    }

}