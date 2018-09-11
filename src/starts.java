import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by wliu on 18/10/16.
 */
public class starts {
    public static void main(String args[]) throws Exception {
        String test ="";
        System.out.println(test.split(" ").length);
        System.out.println(test.split(" ")[0]);
      /*  int row = 10;
        int count = 0;
        for(int i = 0;;i++){
            if(i%2==1){
                count ++;
                for(int j=0; j< row-count; j++){
                    System.out.print(" ");
                }
                for(int starts = 0; starts<i; starts++){
                    System.out.print("*");
                }
                System.out.print("\n");

            }

            if(count == row)
                break;
        }*/
         curlDomain();
//        System.out.println(diff("testtest1","testtest1"));


    }

    public static void curlDomain() throws Exception {
       /* URL url = new URL("http://172.217.25.163");
        InputStreamReader IS = new InputStreamReader(url.openStream(), "UTF-8");
        BufferedReader reader = new BufferedReader(IS);

        for(String line; (line = reader.readLine()) != null;) {
            System.out.println(line);
        }*/

        Process	p = Runtime.getRuntime().exec("curl --resolve www.bbcnz.co.nz:int-1.ezyreg.com www.bbcnz.co.nz");
        p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        LinkedList<String> content = new LinkedList<String>();
        while ((line = reader.readLine())!= null)
        {
            content.add(line);
        }
        for(int i=0; i<content.size(); i++) {
            System.out.println((i+1)+": "+content.get(i));
        }



    }
    public static String diff(String str1, String str2) {
        int index = str1.lastIndexOf(str2);
        if (index > -1) {
            return str1.substring(str2.length());
        }
        return str1;
    }
}
