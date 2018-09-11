import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.List;


/**
 * Created by wliu on 20/11/14.
 */
public class postLoginForm
{
    private static List<String> cookies;
    private static HttpsURLConnection conn;

    private final String USER_AGENT = "Mozilla/5.0";
    private String GetPageContent(String url) throws Exception {

        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // default is GET
        conn.setRequestMethod("GET");

        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

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

    public void sendPost(String url,String postParams) throws Exception{
        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();
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
        conn.setRequestProperty("Content-Length",Integer.toString(postParams.length()));
        conn.setRequestProperty("Content-Typet","application/x-www-form-urlencoded");

        conn.setDoOutput(true);
        conn.setDoInput(true);

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://service-portal.server-secure.com/default.cfm?LogonUsername=vs170862&LogonPassword=87Welsby12"));



    }




    public static void main(String[] args) throws Exception {
       /* System.out.print("hello");
        CookieHandler.setDefault(new CookieManager());
        postLoginForm pL = new postLoginForm();
        String page = pL.GetPageContent("https://service-portal.server-secure.com/default.cfm");*/
        String data = URLEncoder.encode("LogonUsername", "UTF-8") + "=" + URLEncoder.encode("vs170862", "UTF-8");
        data += "&" + URLEncoder.encode("LogonPassword", "UTF-8") + "=" + URLEncoder.encode("87Welsby12", "UTF-8");
//      pL.sendPost("https://service-portal.server-secure.com/default.cfm",data+"&x-36&y-16");
        System.out.println(data);
        java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://service-portal.server-secure.com/default.cfm?"+data));
    }
}
