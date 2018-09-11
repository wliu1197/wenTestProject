import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;
/**
 * Created by wliu on 19/11/14.
 *
 * https://service-portal.server-secure.com/default.cfm
 * https://service-portal.server-secure.com/
 */
public class postFormTest
{

    private static List<String> cookies;
    private String GetPageContent(URL url) throws Exception {

        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        // default is GET
        conn.setRequestMethod("GET");

        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }
        in.close();

        // Get the response cookies
        setCookies(conn.getHeaderFields().get("Set-Cookie"));

        return response.toString();

    }
    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public static void main(String[] args)
    {
        postFormTest pft = new postFormTest();
        System.out.println("Hello, World!");
        try {
            String data = URLEncoder.encode("LogonUsername", "UTF-8") + "=" + URLEncoder.encode("vs170862", "UTF-8");
            data += "&" + URLEncoder.encode("LogonPassword", "UTF-8") + "=" + URLEncoder.encode("87Welsby12", "UTF-8");
            Map domainStore = new HashMap();

            URL url = new URL("https://service-portal.server-secure.com/default.cfm");
            pft.GetPageContent(url);
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Host", "service-portal.server-secure.com");
            conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            conn.setRequestProperty("Accept-Encoding","gzip, deflate");
            conn.setRequestProperty("Accept-Language","en-US,en;q=0.5");
            conn.setRequestProperty("Connection","keep-alive");
            for (String cookie : cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
            conn.setRequestProperty("Referer","https://service-portal.server-secure.com/default.cfm");
            conn.setRequestProperty("Content-Length",Integer.toString(data.length()));
            conn.setRequestProperty("Content-Typet","application/x-www-form-urlencoded");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

            wr.close();
            rd.close();


            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://service-portal.server-secure.com/default.cfm"));

        } catch (Exception e) {

        }


    }

}
