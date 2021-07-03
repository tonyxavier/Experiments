package lab.design.elevator;

import java.util.LinkedList;


public class Elevator {

    int current, direction;

    Status status;

    boolean emergency = false;

    LinkedList<Integer> requestQueue;


    //status can be active, shut

    enum Status {

        ACTIVE, SHUT

    }


    Elevator() {
        current = 0;
        direction = 0;
        status = Status.ACTIVE;
        requestQueue = new LinkedList<Integer>();

    }


    //-1 indicates down and +1 indicates up for direction. 0 indicates no moving
    private class Request {
        int level, direction;


        Request(int level, int direction) {

        }


    }


    public void addRequest(int level) {

        requestQueue.add(level);


    }


    private void moveUp() {


    }

    private void moveDown() {

    }


    public void ringAlarm() {

    }


    private void open() {

        System.out.println("Opening at " + current);
        requestQueue.remove(current);


    }

    private void close() {

        System.out.println("Closing at " + current);


    }


    private void gotoFloor(int level) {

        try {
            Thread.sleep(3000);
            current = level;
        } catch (InterruptedException ie) {
            ie.printStackTrace();

        }


    }


    public void run() {


        while (true) {


            while (!requestQueue.isEmpty()) {


            }


            if (emergency) {

                open();

            }


        }


    }


    public void shutDown() {
        status = Status.SHUT;

    }

    public void emergencyStop() {

        //open at next floor
        //Stop taking new requests
        //Flush all existing requests


    }


    public static void main(String args[]) {

        Elevator elevator = new Elevator();


    }


}
