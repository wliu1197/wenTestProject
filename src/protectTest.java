import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wliu on 13/01/16.
 */
public class protectTest {
    public static Double num1= 33.3300;
    public static Double num2 = 33.33;
    public static void main(String args[]) {
        /*Child1 c1= new Child1();
        c1.varArgTest(1,2,3,4,5,6);
        String [] sdfsdf = null;
        try {
            System.out.print(sdfsdf[0]);
        }catch (RuntimeException e) {
            System.out.print("run time");
        }catch (Exception e) {
            System.out.print("Exception");
        }*/

      /*  genericObject<String> g= new genericObject <String> ("test");
        System.out.println(g.getT());

        hashTest h1 = new hashTest(2,"2","sss");
        hashTest h4 = new hashTest(2,"2","lll");
//        hashTest h2 = new hashTest(3,"2");
//        hashTest h3 = new hashTest(4,"4");
//        System.out.println(h1.hashCode());
//        System.out.println(h2.hashCode());
//        System.out.println(h1.equals(h2));

        HashSet<hashTest> h = new HashSet<hashTest>();
        h.add(h1);
        h.add(h4);
        System.out.println(h.size());
        System.out.println(h.contains(h1));*/

        /*System.out.println(gcd(1440,408));
        for(int i = 1; i<= 8; i++) {
            System.out.println(fibonacci(i));
        }

*/
//        System.out.println(removeVowels("recurse",0));

        System.out.println(NumberUtils.equals(33.3300, 33.33));
    }
    public static String removeVowels(String s,int index){
        if(index > s.length()) return s;
        String ch = String.valueOf(s.charAt(index));
        Pattern p = Pattern.compile("a|e|i|o|u|A|E|I|O|U");
        Matcher m = p.matcher(ch);
        if(m.find()){
            StringBuilder sb =new StringBuilder(s);
            return removeVowels(sb.deleteCharAt(index).toString(),index+1);
        }else {
            return removeVowels(s,index+1);
        }
    }

    public static int nTimes(int x,int n) {
        if(n==0) return 1;
        return x*nTimes(x, n - 1);
    }
    public static int gcd(int p, int q) {

        if(q == 0) {
            return p;
        }
        else
        return gcd(q,p%q);

    }

    public static int fibonacci(int n) {
        if(n==1 || n==2) {
            return 1;
        }
        else {
            return fibonacci(n-2) + fibonacci(n-1);
        }

    }



}
class hashTest {
    public int i;
    public String name;
    public String team;
    hashTest(int i,String name,String team){
        this.i =i;
        this.name = name;
        this.team = team;
    }
    public boolean equals(Object obj){
        hashTest h = (hashTest)obj;
        if(h.name.equals(name)){
            return true;
        }
        return false;
    }
    public int hashCode(){
        return i;
    }
}
class SuperClass1 {
    protected int x=2;
}
class Child1 extends SuperClass1{
    public void test(){
        System.out.println(x);
    }
    public void varArgTest(int ... x){
        for(int num:x)
        System.out.println(num);
    }

}
class Child2 extends Child1{
    public void test(){
        System.out.println(x);
    }
}

interface gIn <T> {
    T getT();
}
class genericObject <T> implements gIn{

    public T t;

    genericObject(T t) {
        this.t = t;
    }
    public T getT() {
        return this.t;
    }
}
class NumberUtils {

    public final static String DECIMAL_FORMAT = "###,##0.00";
    public final static String WHOLE_NUMBER_FORMAT = "###,###";
    public final static String DECIMAL_NO_WHOLE_NUMBER_FORMAT = ".00";

    public final static Double TOLERANCE = 0.005d;

    /**
     * Compares two <code>Double</code> objects numerically. Arguments can be <code>null</code>.
     * If both arguments are <code>null</code>, then the numbers are equal.
     * If the first argument is <code>null</code>, then the result is <code>-1</code>.
     * If the second argument is <code>null</code>, then the result is <code>1</code>.
     * If both arguments are not null, the result is:
     * <blockquote><pre>
     *     num1.compareTo(num2);
     * </pre></blockquote>
     * A value less than <code>0</code> if the first argument is numerically less than the second argument;
     * A value greater than <code>0</code> if the first argument is numerically greater than the second argument;
     */
    public static int compareTo(Double num1, Double num2) {
        if (num1 == null && num2 == null)
            return 0;

        if (num1 == null)
            return -1;

        if (num2 == null)
            return 1;

        return num1.compareTo(num2);
    }

    public static String formatNumber(Double num) {
        return formatNumberWithPattern(num, DECIMAL_FORMAT);
    }

    public static String formatWholeNumber(Double num) {
        return formatNumberWithPattern(num, WHOLE_NUMBER_FORMAT);
    }

    public static String formatDecimalNoWholeNumber(Double num) {
        return formatNumberWithPattern(num, DECIMAL_NO_WHOLE_NUMBER_FORMAT);
    }

    public static String formatNumberWithPattern(Double num, String pattern) {
        DecimalFormat formatter = new DecimalFormat(pattern);
        return formatter.format(num);
    }

    public static double round(double num) {
        return Math.rint(num * 100) / 100;
    }

    public static boolean equals(Double num1, Double num2) {
        return num1 == null ? num2 == null : num2 != null && equals((double) num1, (double) num2);
    }

    public static boolean equals(double num1, double num2) {
        double num1Rounded = round(num1);
        double num2Rounded = round(num2);
        return num1Rounded == num2Rounded;
    }

    public static boolean equalsWithTolerance(double num1, double num2) {
        //are the two numbers the sameish?
        return Math.abs(num1 - num2) < TOLERANCE;
    }

    public static boolean notEquals(double num1, double num2) {
        double num1Rounded = round(num1);
        double num2Rounded = round(num2);
        return num1Rounded != num2Rounded;
    }

    public static boolean lessThan(double num1, double num2) {
        double num1Rounded = round(num1);
        double num2Rounded = round(num2);
        return num1Rounded < num2Rounded;
    }

    public static boolean lessThanEquals(double num1, double num2) {
        double num1Rounded = round(num1);
        double num2Rounded = round(num2);
        return num1Rounded <= num2Rounded;
    }

    public static boolean greaterThan(double num1, double num2) {
        double num1Rounded = round(num1);
        double num2Rounded = round(num2);
        return num1Rounded > num2Rounded;
    }

    public static boolean greaterThanEquals(double num1, double num2) {
        double num1Rounded = round(num1);
        double num2Rounded = round(num2);
        return num1Rounded >= num2Rounded;
    }

    public static double roundToSignificantFigures(double num, int n) {
        if (num == 0) {
            return 0;
        }

        final int d = (int) Math.ceil(Math.log10(Math.abs(num)));
        final int power = n - d;
        final double magnitude = Math.pow(10, power);
        final long shifted = Math.round(num * magnitude);
        return shifted / magnitude;
    }
}