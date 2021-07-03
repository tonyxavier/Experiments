package lab.problems.strings;


/*
A valid number can be split up into these components (in order):

A decimal number or an integer.
(Optional) An 'e' or 'E', followed by an integer.
A decimal number can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
One of the following formats:
At least one digit, followed by a dot '.'.
At least one digit, followed by a dot '.', followed by at least one digit.
A dot '.', followed by at least one digit.
An integer can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
At least one digit.
For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

Given a string s, return true if s is a valid number.

https://leetcode.com/problems/valid-number/
 */

public class RegexForNumber {

    public static void main(String[] args) {

    }


    public boolean isNumber(String input){


        if(isDecimal(input)||isInteger(input))
            return true;
        else
            return false;

    }

    private boolean isDecimal(String input){
        return false;
    }

    private boolean isInteger(String input){


        Character firstChar = input.charAt(0);

        if(!isDigit(firstChar) && !(firstChar=='+' || firstChar=='-'))
            return false;

        if(isSigned(input) && input.length()<2)
            return false;


        int i=0;
        if(isSigned(input))
            i=1;
        for (;i<input.length();i++)
            if(!isDigit(input.charAt(i)))
                return false;


        return true;

    }




    private boolean isSign(Character c){
        if(c=='+' || c=='-')
            return true;
        else
            return false;
    }


    private boolean isDigit(Character c){

        if(c=='0' || c=='1')
            return true;
        else
            return false;
    }

    private boolean isSigned(String input){
        if(input.charAt(0)=='+' || input.charAt(0)=='-')
            return true;
        else
            return false;
    }

}
