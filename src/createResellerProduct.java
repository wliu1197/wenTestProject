import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wliu on 10/08/15.
 */
public class createResellerProduct {
    public static int numberOfresllerInOneCall = 10;
    public static String outfileName = "TheConsole7261_RProd.sql";
    public static String infileName = "whoisPrivacyResellerIds.txt";
    public static String resellerProductName = "Domain Privacy";
    public static String resellerProductDescription = "<p>Keep your domain contact details private and hide them from public view.</p>";

    public static int productId = 100320; //Whois-privacy product_id for v10

    public static void main(String [] args) throws UnsupportedEncodingException {
        try {
            Scanner in = new Scanner(new FileReader(infileName));
            String ids = in.next();
            LinkedList<String> resellerIdList = new LinkedList <String> (Arrays.asList(ids.split(",")));
            boolean reset = true;
            String updateQuery = "";
            int countRow=0;
            System.out.println(resellerIdList.size());
            for(int i=0; i< resellerIdList.size(); i++) {
                countRow ++;
                if(reset) {
                    updateQuery = "Select create_reseller_product(ARRAY[";
                    reset = false;
                }
                if(((i+1)%numberOfresllerInOneCall == 0)|| i == resellerIdList.size()-1) {
                    updateQuery = updateQuery + resellerIdList.get(i) + "]," + productId +",'"+resellerProductName+"','"+resellerProductDescription+"');";
                    reset = true;
                    System.out.println(updateQuery);
                    PrintWriter writer = new PrintWriter(new FileOutputStream(new File(outfileName),true));
                    writer.println(updateQuery);
                    writer.close();
                    System.out.println(countRow);
                }
                updateQuery = updateQuery + resellerIdList.get(i) + ",";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
