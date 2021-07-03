package lab.ds.stack;

public class StackApp {

    public StackApp() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]) {
        StackApp app = new StackApp();

        //Stack stack=new ArrayStack();

        Stack stack = new MinFindingStack();


        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);


        app.reverse(stack);


        while (true) {

            int v = stack.pop();

            if (v == Integer.MIN_VALUE)
                break;
            else
                System.out.println(v);

        }


    }


    public void reverse(Stack s) {

        if (s.isEmpty())
            return;


        int bottom = getBottom(s);

        //Now the bottom element has been removed from the stack.
        //All other elements remain intact.
        reverse(s);

        s.push(bottom);


    }


    private int getBottom(Stack s) {

        //Advancing phase of the recursion
        int top = s.pop();

        if (s.isEmpty()) {

            return top; //if stack becomes empty after popping, top is the bottom element
        } else {


            int bottom = getBottom(s);  //All invocations of the method holds the same value
            //which is returned by the last invocation.


            //Returning phase of the recursion
            //--------------------------------

            s.push(top); //Put back whatever was taken from the stack except for the bottom element


            return bottom;


        }

    }


}
