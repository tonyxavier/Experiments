package lab.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public ThreadPoolTest() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(18);

        for (int i = 0; i < 50; i++) {
            Runnable uploader = new UploadImage();

            executor.execute(uploader);

        }


        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");


    }


    public boolean isRotation(String a, String b) {

        return false;
    }


}
