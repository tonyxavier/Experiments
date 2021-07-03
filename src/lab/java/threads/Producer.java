package lab.java.threads;

import java.util.Random;

import lab.ds.queue.Queue;

public class Producer implements Runnable {

    static int numberProduced = 0;

    Queue queue; //The queue to which the producer produces.
    //Typically the Consumer also consumes from the same queue;
    //Good Example of decoupling using composition


    public Producer(Queue q) {
        queue = q;
    }


    public void run() {


        try {

            while (numberProduced < 50) {
                Random r = new Random();

                int rn = r.nextInt() % 500;

                if (rn < 0)
                    rn = rn * -1;


                Thread.sleep(rn); //To simulate the random time taken to produce


                synchronized (queue) {

                    if (queue.isFull()) {
                        queue.wait();
                        //Producer (current thread) is waiting ON queue object for the consumer to notify threads waiting ON queue object

                    } else {
                        //If this section is not synchronized either another Producer thread or a Consumer thread can cause race condition
                        queue.enqueue(numberProduced);
                        System.out.println("Producing :" + numberProduced);
                        queue.notify();

                    }

                }


                numberProduced++;


            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }

}
