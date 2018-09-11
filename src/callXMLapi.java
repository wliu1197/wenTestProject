import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by wliu on 14/09/15.
 */
public class callXMLapi {
    public static void main(String args[]) {
        try {
            System.out.println("hello");
                HttpClient client = new DefaultHttpClient();
//              HttpPost post = new HttpPost("https://api.SiteLock.com/v1/partner");
                HttpPost post = new HttpPost("https://api.SiteLock.com/v1/partner");
                String xml ="<SiteLockOnlineRequest><authentication><user>XXX</user><password>XXX</password></authentication><scanDomain><domain>scandomain.org</domain></scanDomain></SiteLockOnlineRequest>";//              String xml = "<xml>xxxx</xml>";
                HttpEntity entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
                post.setEntity(entity);
                HttpResponse response = client.execute(post);
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
        } catch (Exception e) {
            System.err.println("Error occurred while sending Request to Server");
            e.printStackTrace();
        }
    }

}
