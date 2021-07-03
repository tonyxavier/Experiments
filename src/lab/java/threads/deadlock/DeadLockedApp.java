package lab.java.threads.deadlock;


//Sometimes this application may not cause deadlock if the execution of second thread
//starts after the first thread finishes.
public class DeadLockedApp {

    public DeadLockedApp() {

    }


    public static void main(String args[]) {

        SharedFile1 f1 = new SharedFile1();
        SharedFile2 f2 = new SharedFile2();


        Thread t1 = new Thread(new FileWriter1(f1, f2));

        t1.start();


        Thread t2 = new Thread(new FileWriter2(f1, f2));
        t2.start();


    }

}
