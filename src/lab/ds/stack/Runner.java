package lab.ds.stack;

public class Runner {


    public static void main(String args[]) {

        MinStack stack = new MinStack();


        stack.push(8);
        stack.push(7);

        System.out.println(stack.getMin());


        stack.push(4);
        stack.push(6);
        stack.push(5);

        System.out.println(stack.getMin());

        stack.push(9);
        stack.push(2);

        System.out.println(stack.getMin());

        stack.push(11);

        System.out.println(stack.getMin());

        System.out.println("Poppin..");

        stack.pop();

        stack.pop();


        stack.pop();

        System.out.println(stack.getMin());

        stack.pop();


        stack.pop();

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());


    }


}
