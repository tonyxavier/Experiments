package lab.problems.strings;

public class StringMatchWithOperatorsInside {

    public static void main(String[] args) {


        String str1,str2;


        //Both Empty and True
        str1="";
        str2="a####";
        //System.out.println(doMatchBruteForce(str1,str2));
        System.out.println(doMatchOptimized(str1,str2));



        //False
        str1="xy##bb#";
        str2="aaa##bb#";
        //System.out.println(doMatchBruteForce(str1,str2));
        System.out.println(doMatchOptimized(str1,str2));


         str1="###zaaa###bb";
         str2="#zxxx###bb";
        //System.out.println(doMatchBruteForce(str1,str2));
        System.out.println(doMatchOptimized(str1,str2));


         str1="zaaa###bb";
         str2="zxxx###bb";
        // System.out.println(doMatchBruteForce(str1,str2));
        System.out.println(doMatchOptimized(str1,str2));





    }

    public static boolean doMatchOptimized(String first, String second){

        char[] str1 = first.toCharArray();
        char[] str2 = second.toCharArray();
        int i=first.length()-1;
        int j=second.length()-1;

        while (i>=0 || j>=0){

            int moveCount=0;
            while(i>=0 && (str1[i]=='#' || moveCount>0 )){ //either its a # or we have deletes pending

                if(str1[i]=='#') {
                    moveCount++;
                    i--;
                }

                if(i>=0 && str1[i]!='#' && moveCount>0) {
                    moveCount--;
                    i--;
                }

            }

            moveCount=0;
            while( j>=0 && (str2[j]=='#' || moveCount>0)){

                if(str2[j]=='#') {
                    moveCount++;
                    j--;
                }

                if(j>=0 && str2[j]!='#' && moveCount>0) {
                    moveCount--;
                    j--;
                }

            }

            System.out.println(i + " "+ j);

            if(i==-1 && j==-1)
                return true;

            if((i==-1 && j!=-1)|| (j==-1 && i!=-1))
                return false;


            if(str1[i]==str2[j]) {
                i--;
                j--;
            }
            else
                return false;

        }

        return true;


    }




    public static boolean doMatchBruteForce(String first,String second){

        return applyBackSpaceOperator(first).equals(applyBackSpaceOperator(second));

    }

    private static String applyBackSpaceOperator(String str){

        //# is the backspace operator

        char[] strArr = str.toCharArray();
        char[] finalStr =new char[strArr.length];

        int j=0;
        for(int i=0;i<strArr.length;i++){

            //works like using a stack/Queue
            if(strArr[i]!='#')
                finalStr[j++]=strArr[i];
            else{
                 j= (j > 0 )? j-1 : 0;
            }

        }


        return new String(finalStr,0,j);

    }


    //Counts the length of string aftr aplying the backspace operator
    private static int countStringLength(String str){
        char[] strArr = str.toCharArray();

        int count=0;

        for(int i=0;i<strArr.length;i++){
            if(strArr[i]!='#')
                count++;
            else if(strArr[i]=='#' && count>0)
                count--;

        }
          return count;

    }


}
