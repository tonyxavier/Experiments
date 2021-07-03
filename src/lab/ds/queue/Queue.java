package lab.ds.queue;

public class Queue {

    private Node front, rear;
    private int size;
    private int CAPACITY = 2;


    public Queue() {


    }


    public Queue(int capacity) {
        CAPACITY = capacity;


    }


    private class Node {

        int data;

        Node next;


    }


    public void setSize(int s) {
        CAPACITY = s;
    }

    public boolean isEmpty() {

        if (front == null)
            return true;
        else
            return false;

    }

    public boolean isFull() {

        if (size == CAPACITY)
            return true;
        else
            return false;
    }


    public static void main(String args[]) {

        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);


        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());


    }


    public void enqueue(int value) {
        Node newnode = new Node();
        newnode.data = value;
        newnode.next = null;


        if (isEmpty()) {

            rear = newnode;
            front = newnode;
            size++;

        } else {
            if (size <= CAPACITY) {
                rear.next = newnode;
                rear = newnode;
                size++;
            }


        }


    }

    public Integer dequeue() {


        if (isEmpty()) {

            return null;
        } else {
            int value = front.data;
            front = front.next;
            size--;
            return value;


        }


    }


}
