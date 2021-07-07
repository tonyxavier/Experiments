package lab.java.functional;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFunctionConsumerDemo {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1,1,2,3,5,8,13);
        printSquareOfEvenNumbersTheFunctionalWay(nums);


    }




    private static void printSquareOfEvenNumbersTheFunctionalWay(List<Integer> numbers){

        Predicate<Integer> evenNumbersOnly = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num%2 ==0;
            }
        };


        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n*n;
            }
        };

        Consumer<Integer> print = new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {

                System.out.println(num);
            }
        };


        numbers.stream()
                .filter(evenNumbersOnly)
                .map(square)
                .forEach(print);

    }




}
