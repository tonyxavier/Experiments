package lab.java.threads;

import java.util.Random;

public class UploadImage implements Runnable {

    private static int i = 1;
    private static Random random = new Random();


    public UploadImage() {
        // TODO Auto-generated constructor stub
    }


    public void run() {

        int min = 3000, max = 20000;
        int n = max - min;


        int r = random.nextInt();

        if (r < 0)
            r = r * -1;


        //System.out.println("Random "+r);


        //int sl=r%n;

        //System.out.println("sleep"+sl);


        try {
            Thread.sleep(r % n);

            synchronized (this) {
                System.out.println(i + "th image uploaded");
                i++;
            }
        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }

    }


}
