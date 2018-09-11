/**
 * Created by wliu on 22/10/15.
 */
public class synchoronizationDemo {
    public static void main (String [] args)
    {
        FinTrans ft = new FinTrans ();
        Object lock = new Object();
        TransThread tt1 = new TransThread (ft, "Deposit Thread",lock);
        TransThread tt2 = new TransThread (ft, "Withdrawal Thread",lock);
        tt1.start ();
        tt2.start ();
    }
}
class FinTrans
{
    public static String transName;
    public static double amount;
}
class TransThread extends Thread
{
    private Object lock;
    private FinTrans ft;
    TransThread (FinTrans ft, String name,Object lock)
    {
        super (name); // Save thread's name
        this.ft = ft; // Save reference to financial transaction object
        this.lock = lock;
    }
    public void run ()
    {
        int depositCount = 0;
        int withdrawalCount = 0;
        for (int i = 0; i < 100; i++)
        {
            if (getName().equals ("Deposit Thread"))
            {
                synchronized (lock)
                {
                    ft.transName = "Deposit";
                    try
                    {
                        Thread.sleep ((int) (Math.random () * 1000));
                    }
                    catch (InterruptedException e)
                    {
                    }

                    ft.amount += 2000.0;
                    depositCount ++;
                    System.out.println (ft.transName + " " + ft.amount + " Deposit count:" + depositCount);
                }
            }
            else
            {
                synchronized (lock)
                {
                    ft.transName = "Withdrawal";
                    try
                    {
                        Thread.sleep ((int) (Math.random () * 1000));
                    }
                    catch (InterruptedException e)
                    {
                    }
                    ft.amount -= 2500.0;
                    withdrawalCount ++;
                    System.out.println (ft.transName + " " + ft.amount + " Withdrawal Count:" +withdrawalCount);
                }
            }
        }
    }
}
