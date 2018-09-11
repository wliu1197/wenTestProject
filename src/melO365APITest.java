import org.apache.commons.codec.binary.Base64;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by wliu on 29/06/16.
 */
public class melO365APITest {
    private static String API_SERVER = "https://stage.provisioning-api.melbourneit.com.au/v1/jwt/tenants/123";
    private static String API_CREDENTIAL = "test:testpassword";


    public static String call() {
        try {
            String response = "";
            ignoreName();
            URL url = new URL(API_SERVER);
            String encoding = Base64.encodeBase64String(API_CREDENTIAL.getBytes("utf-8"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            connection.setDoOutput(true);

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
    public static String responseToString(BufferedReader in) throws IOException {
        String response ="",line="";
        while ((line = in.readLine()) != null) {
            response += line + "\n";
        }
        return response;
    }


    public static void main(String [] args){
        call();
    }

}
