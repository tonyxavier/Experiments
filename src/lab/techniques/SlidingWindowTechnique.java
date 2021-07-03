package lab.techniques;


//Given an array of integers find 3 (or N) contigouos integers that form the given sum/greatest sum

public class SlidingWindowTechnique {

    public static void main(String[] args) {

        //1 Empty input
        int[] input1 ={};
        System.out.println("Empty input:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input1,3));


        //2 N>input size
        int[] input2 ={1,2};
        System.out.println("N>input size:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input2,3));


        //3 - N==0
        int[] input3 ={1,2};
        System.out.println("N==0:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input3,0));


        //4 Usual case
        int[] input4 ={1,2,0,8,7,-1,3};
        System.out.println("Usual case:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input4,3));


        //5 n==1
        int[] input5 ={1,2,0,8,7,-1,3};
        System.out.println("n==1:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input5,1));


        //6 All elements are negetive

        int[] input6 ={-1,-2,-8,-7,-1,-3};
        System.out.println("All -ve:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input6,3));




        //7 n==input length

        int[] input7 ={-1,5,-8,21,-1,-3};
        System.out.println("n==input length:"+findGreatestSumFormedByNContiguousIntegersSlidingWindow(input7,6));




    }


    public static int findGreatestSumFormedByNContiguousIntegersBruteForce(int[] input, int n){

        if(input.length<n)
            return -1;

        if(n<1)
            return -1;

        if(n>input.length)
            return -1;

        int start=0,end=n-1;
        int maxSum=getSumOfNContiguousElements(input,start,end);
        int sum = maxSum;
        for(int i=1;i<=input.length-n;i++){

            sum = getSumOfNContiguousElements(input,i,i+n-1);

            if(sum > maxSum)
                maxSum = sum;

        }
        return maxSum;

    }


    //You don't have to calculate the sum always; You just add the last number to the sum and subtract the first number
      public static int findGreatestSumFormedByNContiguousIntegersSlidingWindow(int[] input, int n){

        if(input.length<n)
            return -1;

        if(n<1)
            return -1;

        if(n>input.length)
            return -1;

        int start=0,end=n-1;
        int maxSum=getSumOfNContiguousElements(input,start,end);
        int sum = maxSum;
        for(int i=0;i<=input.length-n-1;i++){

            sum = sum + input[i+n] - input[i];

            if(sum > maxSum)
                maxSum = sum;

        }
        return maxSum;

    }



    private static int getSumOfNContiguousElements(int[] input,int start,int end){


        int sum=0;
        for(int i=start;i<=end;i++){
            sum=sum+input[i];
        }

        return sum;


    }


}
