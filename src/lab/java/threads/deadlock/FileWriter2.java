package lab.java.threads.deadlock;

public class FileWriter2 implements Runnable {

    SharedFile1 file1;
    SharedFile2 file2;

    public FileWriter2(SharedFile1 f1, SharedFile2 f2) {
        file1 = f1;
        file2 = f2;

    }

    public void run() {


        synchronized (file2) {

            System.out.println("Writing to shared file2 from FileWriter2..");


            synchronized (file1) {

                System.out.println("Writing to shared file1 from FileWriter2..");

            }

        }


    }

}
