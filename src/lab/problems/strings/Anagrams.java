package lab.problems.strings;


//If two words have same letters in different order. Frequency matters.

import java.util.HashMap;

public class Anagrams {

    public static void main(String[] args) {

        Anagrams runner = new Anagrams();

       //Tes1 - Anagrams
        String first="aisabca";
        String second="asiacba";

        System.out.println("Anagram:"+runner.isAnagram(first,second));


        //TEst2 - All letters but different length
         first="aabbcc";
         second="aabbc";

        System.out.println("Anagram:"+runner.isAnagram(first,second));


        //Test3 empty strings
        first="";
        second="";

        System.out.println("Anagram:"+runner.isAnagram(first,second));

    }


    public boolean isAnagram(String first,String second){

        if( first==null || second==null || first.length()!=second.length() )
            return false;


        HashMap<Character,Integer> counter = new HashMap<>();

        for(Character c :first.toCharArray()){

            Integer count = counter.get(c);
            if(count==null){
                counter.put(c,1);
            }
            else{
                counter.put(c,count+1);
            }
        }

        for(Character c:second.toCharArray()){

            Integer count = counter.get(c);
            if(count==null || count==0){
                return false;
            }
            else {
                counter.put(c,count-1);
            }

        }

        return true;

    }


}
