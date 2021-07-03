package lab.algorithms.simple;

import java.util.Set;

public class Problems {


    private static int[] fibLookup = new int[100];


    static {

        fibLookup[1] = 1;
        fibLookup[2] = 1;

    }


    public static void main(String args[]) {

        System.out.println("Fibo:" + nthFibonacciDP(10));

        printFibonacci(10);


    }


    public void allPermutations(String str) {

        char[] chars = str.toCharArray();

        int len = str.length();


    }


    public static int pow(int a, int n) {


        if (n == 0)
            return 1;


        if (n == 1)
            return a;


        int x, y;
        if (n % 2 == 0)//even number
        {
            x = n / 2;
            y = x;
        } else {
            x = (n / 2);
            y = x + 1;
        }

        return pow(a, x) * pow(a, y);


    }


    public static int powOptimized(int a, int n) {

        if (n == 0)
            return 1;
        if (n == 1)
            return a;


        int temp = powOptimized(a, n / 2);

        if (n % 2 == 0) {

            return temp * temp;

        } else {
            return a * temp * temp;
        }
    }


    public static void printFibonacci(int n) {

        int n1 = 0, n2 = 1, n3;

        System.out.print(n1 + " " + n2);

        for (int i = 3; i <= n; i++) {

            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;

        }


    }


    //very inefficient algorith as there's a lot of duplicate computation
    public static int nthFibonacciRecursive(int n) {


        if (n == 1)
            return 0;

        if (n == 2)
            return 1;


        return nthFibonacciRecursive(n - 1) + nthFibonacciRecursive(n - 2);


    }


    public static int nthFibonacciDP(int n) {

        if (fibLookup[n] == 0) {

            fibLookup[n] = nthFibonacciDP(n - 2) + nthFibonacciDP(n - 1);


        }

        return fibLookup[n];


    }


    public Set powerSet(Set s) {


        return s;

    }


}
