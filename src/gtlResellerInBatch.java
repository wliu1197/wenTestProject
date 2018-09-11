import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wliu on 30/06/15.
 */
public class gtlResellerInBatch {
    public static int numberOfresllerInOneCall = 5;
    public static String fileName = "TLD120.sql";
//    public static String tlds ="ARRAY['.plus','.golf','.tours','.gold']";
    public static String tlds ="ARRAY['.courses','.study']";

    //    public static String tlds ="ARRAY['.tires']";
    public static void main(String [] args) throws UnsupportedEncodingException {
        try {
            Scanner in = new Scanner(new FileReader("resellerIds.txt"));
            String ids = in.next();
            LinkedList <String> resellerIdList = new LinkedList <String> (Arrays.asList(ids.split(",")));
            boolean reset = true;
            String updateQuery = "";
            int countRow=0;
            System.out.println(resellerIdList.size());
            for(int i=0; i< resellerIdList.size(); i++) {
                countRow ++;
                if(reset) {
                   updateQuery = "Select fillresellertldprices (ARRAY[";
                   reset = false;
                }
                if(((i+1)%numberOfresllerInOneCall == 0)|| i == resellerIdList.size()-1) {
                   updateQuery = updateQuery + resellerIdList.get(i) + "]," + tlds +");";
                   reset = true;
                   System.out.println(updateQuery);
                   PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName),true));
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
