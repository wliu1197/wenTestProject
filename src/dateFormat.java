import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wliu on 13/04/18.
 */
public class dateFormat {
    public static void main(String[] args) throws Exception {
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        Date expiry = dateFormat.parse("04/2018");
        Date todayDate = new Date();

        System.out.println(dateFormat.format(expiry));
        System.out.println(dateFormat.format(todayDate));


        if(expiry.before(todayDate)){
            System.out.println("expired");
        }else{
            System.out.println("not expired yet");
        }*/
        String expiry ="06/2017";
        String year = expiry.trim().split("/")[1];
        String month = expiry.trim().split("/")[0];
        year = year.substring(year.length() - 2);
        Date ex = new Date();
        ex.setYear(100 + Integer.parseInt(year));
        ex.setMonth(Integer.parseInt(month) - 1);

        System.out.println(Integer.parseInt(month));


        Date today = new Date();
        if(ex.before(today)) {
          System.out.println("expired");
        }else{
          System.out.println("not expired yet");
        }

    }
}
