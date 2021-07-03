package lab.java.threads;

import java.util.Random;

import lab.ds.queue.Queue;

public class Consumer implements Runnable {


    int numberConsumed = 0;

    Queue queue;

    public Consumer(Queue q) {
        queue = q;
    }


    public void run() {

        try {
            while (numberConsumed < 50) {


                Random r = new Random();

                int rn = r.nextInt() % 500;

                if (rn < 0)
                    rn = rn * -1;


                Thread.sleep(rn); //To simulate the random time taken to consume


                synchronized (queue) {

                    if (queue.isEmpty()) {
                        queue.wait();
                    } else {
                        System.out.println("Consuming:" + queue.dequeue());
                        queue.notify();
                    }

                }

                numberConsumed++;

            }

        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }


    }

}
