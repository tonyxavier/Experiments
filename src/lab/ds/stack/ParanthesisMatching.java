package lab.ds.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class ParanthesisMatching {

    public static void main(String[] args) {

        String s= ")))(((";

       // System.out.println(isMatching(s));
        System.out.println(countNumberOfMisMatch(s));

    }




    public static boolean isMatching(String s){

     java.util.Stack<String> stack = new Stack<>();

     try {


         for (char c : s.toCharArray()) {

             if (c == '(')
                 stack.push("(");
             else if (c == ')')
                 stack.pop();
             else
                 return false;

         }
     }catch(EmptyStackException ex){
         return false;
     }

     if(!stack.empty())
         return false;

     return true;

    }


    //Returns the count of mimatch. For example    ")))(((" would return 6. "(()))" would return 1.
    public static int countNumberOfMisMatch(String s){

        java.util.Stack<String> stack = new Stack<>();

        int mismatchcount=0;



            for (char c : s.toCharArray()) {

                try {

                if (c == '(')
                    stack.push("(");
                else if (c == ')')
                    stack.pop();

                }catch(EmptyStackException ex){
                    mismatchcount++;
                }

            }


        return stack.size()+mismatchcount;
    }


}
