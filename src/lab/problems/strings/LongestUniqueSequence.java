package lab.problems.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSequence {
    public static void main(String[] args) {

        //1
        String input ="tmmzuxt";

        System.out.println(getLongestUniqueSubSequenceBeatiful(input));



    }



    public static int getLongestUniqueSubSequenceBeatiful(String s){

       int n = s.length();
        int start=0,end=0;
        int maxLength=0;
        Set<Character> seenChars = new HashSet<>();
        while(start < n && end < n){

            if(!seenChars.contains(s.charAt(end))){

                seenChars.add(s.charAt(end++));
                maxLength =Math.max(maxLength, end - start);
            }else{
                seenChars.remove(s.charAt(start++));
            }

        }

        return maxLength;


    }

    public static int getLongestUniqueSubSequence(String input){

        int start=0;
        int maxLength=0;
        int currentLength=0;
        HashMap<Character,Integer> seenChars = new HashMap<>();
        for(int i=0;i<=input.length()-1;i++){
            Integer index=null;

            if((index=seenChars.get(input.charAt(i)))!=null) { //New character is already there in the window

                while(index>=start) {
                    seenChars.remove(input.charAt(start));
                    start++;
                }

                seenChars.remove(input.charAt(i));

                seenChars.put(input.charAt(i),i);
                currentLength = i - index;


            }
            else {
                currentLength++;
                seenChars.put(input.charAt(i),i);

                if(currentLength > maxLength)
                    maxLength = currentLength;
            }


        }


        return maxLength;

    }




}
