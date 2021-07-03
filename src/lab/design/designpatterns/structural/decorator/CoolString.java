package lab.design.designpatterns.structural.decorator;

/*

Decorator is used when You want to augment existing functionality of an object, WITHOUT CHANGING EXISTING CODE,
 Inheritance can be used, but that's not possible when the class is final.

Suppose you wanted to have the isPalindrome() method in String class? Since String is final, you wont be able to inherit.
  The option you have is a Decorator.

 */


public class CoolString {

    private String string;


    public int length(){

        return string.length();
    }




    public boolean isPalindrome(){



        return true;
    }

}
