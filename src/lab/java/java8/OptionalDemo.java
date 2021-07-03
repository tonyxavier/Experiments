package lab.java.java8;

import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;

public class OptionalDemo {



    public static void main(String[] args) {

        OptionalDemo demo =new OptionalDemo();
        Optional<Integer> num1,num2;

         num1 = demo.integerProcessor(demo.readInput("Num1:"));
         num2 = demo.integerProcessor(demo.readInput("Num2:"));

        System.out.println("Sum is:"+ demo.calculateSum(num1,num2));


    }



    private Integer calculateSum(Optional<Integer>n1, Optional<Integer>n2){

        Integer num1 = n1.orElse(0);
        Integer num2 = n2.orElse(0);

        return num1 + num2 ;


    }




    private Optional<Integer> integerProcessor(String userInput){

        Integer num=null;
        try {
             num = Integer.parseInt(userInput);
        }
        catch (Exception e){
           // e.printStackTrace();
        }

        System.out.println("Value from integerProcessor:"+num);
        Optional<Integer> num1 = Optional.ofNullable(num);
        return num1;

    }



    private String readInput(String msg){



        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);

        return scanner.nextLine();






    }




}
