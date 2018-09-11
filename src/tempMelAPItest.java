import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wliu on 13/10/15.
 */
public class tempMelAPItest {
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
    public static void getOrder() {
        try {
            ignoreName();
            URL url = new URL("https://stage-public.provisioning-api.melbourneit.com.au/v1/vaps/order/366873");
            String encoding = Base64.encodeBase64String("test:testpassword".getBytes("utf-8"));
            System.out.println(encoding);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setRequestProperty("Content-Type", "application/json");
            InputStream content;
            if (connection.getResponseCode() == 200) {
                content = connection.getInputStream();
            }else {
                content = connection.getErrorStream();
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            connection.disconnect();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteOrder(String orderId){
        try {
            ignoreName();
            URL url = new URL("https://stage-public.provisioning-api.melbourneit.com.au/v1/vaps/order/"+orderId);
            String encoding = Base64.encodeBase64String("test:testpassword".getBytes("utf-8"));
            System.out.println(encoding);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            InputStream content;
            if (connection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED || connection.getResponseCode() == HttpURLConnection.HTTP_OK
                    ||  connection.getResponseCode() == HttpURLConnection.HTTP_CREATED ) {
                content = connection.getInputStream();
            }else {
                content = connection.getErrorStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(content));
                String line,result = "";
                while ((line = in.readLine()) != null) {
                    result += line + "\n";
                }
                throw new Exception(result);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            connection.disconnect();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static String createOrder(){
        try {
            ignoreName();
            URL url = new URL("https://stage-public.provisioning-api.melbourneit.com.au/v1/vaps/order");
            String encoding = Base64.encodeBase64String("test:testpassword".getBytes("utf-8"));
            System.out.println(encoding);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(getJsonString().getBytes());
            os.flush();
            System.out.println(getJsonString());
            InputStream content;
            if (connection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED || connection.getResponseCode() == HttpURLConnection.HTTP_OK
                    || connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {

                content = connection.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(content));
                String line,result = "";
                while ((line = in.readLine()) != null) {
                    result += line + "\n";
                }
                System.out.println(result);
                JSONObject jsonResult= new JSONObject(result);
                return jsonResult.getJSONObject("order").get("orderId").toString();

            }else {
                System.out.println(connection.getResponseCode());
                content = connection.getErrorStream();
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            connection.disconnect();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJsonString() throws JSONException {
        JSONObject result = new JSONObject();
        JSONObject provisionData = new JSONObject();
        JSONObject customerData = new JSONObject();
        JSONObject productProvisionData = new JSONObject();
        JSONObject provisionConfig = new JSONObject();

        //customer data
        customerData.put("lastName","TestLastName");
        customerData.put("fax","");
        customerData.put("state","NSW");
        customerData.put("postCode","2200");
        customerData.put("addressLine2","");
        customerData.put("addressLine1","line1");
        customerData.put("city","sydney");
        customerData.put("countryCode","AU");
        customerData.put("phoneNumber","+61400022");
        customerData.put("email","sdfsd@netregistry.com.au");
        customerData.put("company","NRG");
        customerData.put("province","");
        customerData.put("firstName","testFName");

        //product data
        productProvisionData.put("businessCategory","Communications & IT");
        provisionConfig.put("hostingUsername","");
        provisionConfig.put("hostingPassword","");
        provisionConfig.put("hostingURL","");
        provisionConfig.put("emailUsername","");
        provisionConfig.put("emailPassword","");
        productProvisionData.put("provisionConfig",provisionConfig);

        provisionData.put("domainName","testdomain.com");
        provisionData.put("customerData",customerData);
        provisionData.put("productProvisionData",productProvisionData);

        result.put("productCode","SPOTDIFM1STM");
        result.put("resellerUsername","");
        result.put("provisionData", provisionData);

        return result.toString();
    }
    public static void main(String []args){
        createOrder();
    }
}
