package lab.problems.simple;

public class StringProblems {

    public StringProblems() {
        // TODO Auto-generated constructor stub
    }


    public static boolean isAnagrams(String a, String b) {

        int[] letters = new int[256];

        if (a.length() != b.length())
            return false;


        for (int i = 0; i < a.length(); i++) {

            letters[a.charAt(i)]++;
            letters[b.charAt(i)]--;

        }


        for (int i = 0; i < a.length(); i++) {

            if (letters[a.charAt(i)] != 0)
                return false;


        }


        return true;
    }


    public static String urlEncodeSpace(String str) {


        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spaceCount++;
        }


        int newlength = str.length() + 2 * spaceCount; //extra 2 characters


        char[] chararr = new char[newlength];


        for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                chararr[j] = '%';
                chararr[j + 1] = '2';
                chararr[j + 2] = '0';
                j = j + 3;
            } else {
                chararr[j++] = str.charAt(i);
            }

        }


        return new String(chararr);

    }


    public static void main(String[] args) {
		
		/*
		 
		 //Check if two strings are anagrams
		boolean ana=isAnagrams("b@atbs3k!","@sab2bkt!");
		
		if(ana)
			System.out.println("Anagrams!!");
		else
			System.out.println("Not Anagrams!!");
		*/


        System.out.println(urlEncodeSpace("This is the String"));

    }


}
