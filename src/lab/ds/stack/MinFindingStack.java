package lab.ds.stack;

public class MinFindingStack extends Stack {

    Node top;


    public boolean isEmpty() {

        if (top == null)
            return true;
        else
            return false;

    }


    public MinFindingStack() {
        // TODO Auto-generated constructor stub
    }


    public void push(int value) {

        Node newnode = new Node();
        newnode.data = value;

        if (isEmpty()) {
            top = newnode;
            newnode.next = null;

        } else {
            newnode.next = top;
            top = newnode;

        }


    }


    public int pop() {

        if (isEmpty())
            return Integer.MIN_VALUE;


        Node temp = top;
        top = temp.next;

        return temp.data;


    }


}
