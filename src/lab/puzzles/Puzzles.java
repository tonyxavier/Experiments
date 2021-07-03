package lab.puzzles;

public class Puzzles {

    public Puzzles() {

    }


    public static void main(String args[]) {


        //	System.out.println(reverseWords("a"));

        System.out.println("Max is:" + returnMax(1, 5));
    }


    public static String reverseWords(String sentence) {

        if (sentence == null || sentence.length() < 1)
            return "Invalid Input";

        String[] words = sentence.split(" ");

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i] + " ");

        }


        return reversed.toString().trim();

    }


    //Return maximum of 2 numbers without using any conditional statement
    public static int returnMax(int a, int b) {

        int c = a - b;

        System.out.println("c=a-b:" + c);

        int k = c >> 31 & 0x1;

        System.out.println("Is a-b -ve:" + k);

        int max = a - k * (a - b);

        return max;

    }


}
