package lab.problems.arrays;

public class ArrayProblems {


    public static void main(String args[]) {

        //reverse("abcd");

        int[] numbers = {-2, -4, 2, 3, -12, 5, 9, -3, 4};


        System.out.println("Max(sum(subarray)): " + maxSumSubArray(numbers));


    }


    public static int maxSumSubArray(int[] numbers) {


        int localMax = 0;
        int globalMax = 0;

        for (int i = 0; i < numbers.length; i++) {
            localMax += numbers[i];


            //if a subset adds up to a -ve number, discard it
            if (localMax < 0)
                localMax = 0;

            //set the new maximum
            if (globalMax < localMax)
                globalMax = localMax;
        }

        return globalMax;
    }


    //determine if a string has all unique characters
    /*
     * 1. Take each character and check with every other character O(n2)
     *
     * 2. Have an integer array of size 26 (number of different characters possible) -ascii value-92 ??
     *    For each character whenever the count become > 1 return false
     *
     * 3.
     *
     *
     *
     *
     *
     *
     *
     *
     */

    private static boolean reverse(String str) {

        char[] strChar = str.toCharArray();

        for (int i = 0, j = strChar.length - 1; i < j; i++, j--) {

            char c = strChar[i];
            strChar[i] = strChar[j];
            strChar[j] = c;


        }

        String str2 = new String(strChar);

        System.out.println(str2);


        return false;
    }




}
