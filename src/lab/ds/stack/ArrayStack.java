package lab.ds.stack;

public class ArrayStack extends Stack {

    private int CAPACITY = 10;
    private int[] stack;
    private int top = -1;

    public ArrayStack() {
        stack = new int[CAPACITY];
    }


    public void push(int value) {

        if (top < CAPACITY - 1) {
            ++top;
            stack[top] = value;
        }


    }


    public int pop() {
        if (!isEmpty())
            return stack[top--];
        else
            return Integer.MIN_VALUE;
    }


    public int peek() {

        if (!isEmpty())
            return stack[top];
        else
            return Integer.MIN_VALUE;


    }

    public boolean isEmpty() {

        if (top == -1)
            return true;
        else
            return false;


    }

    public boolean isFull() {
        if (top == CAPACITY - 1)
            return true;
        else
            return false;

    }


}
