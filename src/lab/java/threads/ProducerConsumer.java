package lab.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lab.ds.queue.Queue;

public class ProducerConsumer {


    private static ProducerConsumer pc = null;
    Queue queue;
    static int filesProcessed = 0;


    private ProducerConsumer() {
        queue = new Queue();
    }


    public static ProducerConsumer getInstance() {

        if (pc == null) {


            synchronized (ProducerConsumer.class) {

                if (pc == null)
                    pc = new ProducerConsumer();

            }


        }

        return pc;


    }


    public static void main(String args[]) {

        Queue queue = new Queue();

        Thread producer = new Thread(new Producer(queue));

        producer.start();


        Thread consumer = new Thread(new Consumer(queue));
        consumer.start();

        try {

            producer.join();

            consumer.join();
        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }


    }


}
