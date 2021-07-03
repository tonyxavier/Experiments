package lab.problems.strings;

//A string is an almost palindrome if you can make it a palindrome by removing one character
public class AlmostPalindrome {

    public static void main(String[] args) {

        String input;
        /*
        input = "abcdcba";
        System.out.println("abcdcba:"+isPalindrome(input));


        input = "abddcba";
        System.out.println("abddcba:"+isPalindrome(input));


        input = "";
        System.out.println(":"+isPalindrome(input));

*/

        input = "abcdcba";
        System.out.println("abcdcba:"+isAlmostPalindrome(input));


        input = "abddcba";
        System.out.println("abddcba:"+isAlmostPalindrome(input));


        input = "";
        System.out.println(":"+isAlmostPalindrome(input));


    }


    public static boolean isAlmostPalindrome(String input){

         int i=0,j=input.length()-1;

         while(i < j){

             if(input.charAt(i)!=input.charAt(j)){
               return  isPalindrome(input.substring(0,i)+input.substring(i+1)) ||
                         isPalindrome(input.substring(0,j)+input.substring(j+1));
             }

             i++;
             j--;

         }

         return true;

    }

    public static boolean isPalindrome(String input){

        if(input==null)
            return false;

        int i=0,j=input.length()-1;

        while(i < j){

            if(input.charAt(i)!=input.charAt(j))
                return false;

            i++;
            j--;

        }
        return true;

    }

}
