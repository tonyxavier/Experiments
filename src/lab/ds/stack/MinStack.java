package lab.ds.stack;

public class MinStack extends ArrayStack {


    ArrayStack min = new ArrayStack();


    public void push(int value) {

        if (isEmpty()) {
            super.push(value);
            min.push(value);
        } else {

            super.push(value);
            int m = min.peek();
            if (value < m) {
                min.push(value);

            }

        }


    }


    public int pop() {

        int v = super.pop();

        if (v == min.peek()) {
            min.pop();
        }


        return v;


    }

    public int getMin() {

        return min.peek();

    }


}
