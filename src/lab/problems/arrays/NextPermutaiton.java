package lab.problems.arrays;


/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).


 */
public class NextPermutaiton {

    public static void main(String[] args) {

        NextPermutaiton numbers =new NextPermutaiton();

        //Test 1 -Best case
       // int[] input={5,4,4,3,4};

        //Test 2 - Already largest
        // int[] input={5,4,4,4,3};



        //TEst3 - Edge - single Element
       // int[] input={2};


        //TEst3 - Edge - single Element
       // int[] input={};

      //  int[] input={1,5,8,4,7,6,5,3,1};
      //  numbers.getNextPermutation(input);

          int[] input={2,3,3,3,1};
          numbers.getNextPermutation(input);


        for (Integer i:input)
            System.out.println(i);


    }


    public int[] getNextPermutation(int[] input){

        int pos = findFirstBigToSmallTransition(input);
        if(pos==-1)
            return reverse(input,0,input.length-1);

        int nextBig = findLastPositionOfNextBigElement(input,input[pos-1],pos,input.length-1);
         swap(input,pos-1,nextBig);
         reverse(input,pos,input.length-1);

         return input;



    }

     private int findLastPositionOfNextBigElement(int[]input, int num, int start,int end){

        int minSoFar=input[start];
        int position=start;
        for(int i=start+1;i<=end;i++)
            if(input[i]>num && input[i]<=minSoFar) {
                minSoFar = input[i];
                position=i;
            }
        return position;

    }



    public int[] swap(int[] input,int pos1,int pos2){

        int temp = input[pos1];
        input[pos1]=input[pos2];
        input[pos2]=temp;
        return input;

    }


    public int findFirstBigToSmallTransition(int[] input){

        for(int i=input.length-1;i>0;i--){
            if(input[i]>input[i-1])
                return i;
        }
        return -1;
    }

    public int[] reverse(int[] input,int start,int end){

        for(int i=start,j=end;i<j;i++,j--){
            int temp = input[i];
            input[i]=input[j];
            input[j]=temp;
        }

     return input;
    }
}
