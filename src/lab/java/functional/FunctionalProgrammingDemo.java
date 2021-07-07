package lab.java.functional;


/*Structured/Procedural vs Functional Programming

Procedural programming, structured programming – specifies the steps a program must take to reach a desired state.
Functional programming – treats programs as evaluating mathematical functions and avoids state and mutable data

 */

//The example shows how printing even numbers from a list of numbers differs in structural programming and functional programming
//A stream is fundamentally different from a list that in a stream, numbers are delivered one after the other.

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgrammingDemo {

    public static void main(String[] args) {


        List<Integer> nums = List.of(1,1,2,3,5,8,13);

        printNumbersTheStructuralWay(nums);

        System.out.println("");

        printNumbersTheFunctionalWay(nums);

        System.out.println("");

        printSquareOfEvenNumbersTheFunctionalWay(nums);

        System.out.println("printSumOfAListOfNumbersTheFunctionalWay:");

        printSumOfAListOfNumbersTheFunctionalWay(nums);

        System.out.println("returnNumbersInSortedOrderTheFunctionalWay:");

        returnNumbersInSortedOrderTheFunctionalWay(nums).stream().forEach(System.out::println);

    }

    private static void printNumbersTheStructuralWay(List<Integer> numbers){

        for (int n:numbers){
            if(n%2 ==0) {
                System.out.println(n);
            }
        }

    }



    private static void printNumbersTheFunctionalWay(List<Integer> numbers){

        numbers.stream()
                .filter(number -> number%2 == 0)
                .forEach(System.out::println);

    }


    //Note that each of the functions/operations return a Stream (java.util.stream.Stream)
    private static void printSquareOfEvenNumbersTheFunctionalWay(List<Integer> numbers){

        numbers.stream()
                .filter(number -> number%2 == 0)
                .map(n -> n*n)
                .forEach(System.out::println);

    }


    private static void printSumOfAListOfNumbersTheFunctionalWay(List<Integer> numbers){

        System.out.println(numbers.stream().reduce((sumsofar,number)->sumsofar+number).get());



    }


    private static int sum(int a, int b){
        return a+b;
    }


    private static List<Integer> returnNumbersInSortedOrderTheFunctionalWay(List<Integer> numbers){

        return numbers.stream().sorted().collect(Collectors.toList());



    }





}
