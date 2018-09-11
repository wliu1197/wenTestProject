/**
 * Created by wliu on 24/09/15.
 */
class ThreadDemo extends Thread {
    ThreadDemo(String name){
        super(name);
    }

    public void run(){
        for(int i=0; i<1000; i++) {
            System.out.print(this.getName() + " : " + i + "\n");
            try {
                this.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableThreadDemo implements Runnable {
    public String ThreadName;

    RunnableThreadDemo(String name){
        this.ThreadName = name;
    }

    public void run() {
        for(int i=0; i<1000; i++) {
            System.out.print(this.ThreadName + " : " + i + "\n");
        }
    }
}


public class javaThread {
    public static void main(String args[]) {
        ThreadDemo t1 = new ThreadDemo("thread-1");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("thread-2");
        t2.start();

        RunnableThreadDemo rT1 = new RunnableThreadDemo("RT1");
        Thread thread_rt1 = new Thread(rT1,rT1.ThreadName);
        thread_rt1.start();

    }

}
