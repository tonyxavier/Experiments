package lab.problems.arrays;

//Test [1,2,-11,3,6,-9,8,6]   {-2, -3, 4, -1, -2, 1, 5, -3}
public class MaxSumSubArray {
    public static void main(String[] args) {

        //Tests



        int[] a =  {1,2,-11,3,6,-9,8,6};
        System.out.println("a:"+maxSumSubArray(a));

        //Edge cases

        //1.Empty array

        int[] empty =  {};
        System.out.println("empty:"+maxSumSubArray(empty));

        //1. Only 1 -ve element
        int[] negative =  {-1};
        System.out.println("negative:"+maxSumSubArray(negative));


        //All negative

        int[] allnegative =  {-3,-2,-6,-1};
        System.out.println("allnegative:"+ maxSumSubArray(allnegative));


        //All zeros
        int[] zeros =  {0,0,0,0,0,0,0};
        System.out.println("zeros:"+maxSumSubArray(zeros));


        /*
        int[] pos = positionOfMaxSumSubArray(a);
        System.out.println(pos[0]+" "+pos[1]);
*/
    }





    public static int maxSumSubArray(int[] a){

        if(a==null || a.length==0)
            return 0;

     int currentSum=0;
     int maxSum=a[0];

     for(int i=0;i<a.length;i++){

         currentSum=currentSum+a[i];

         if(maxSum<currentSum)
             maxSum=currentSum;

           if(currentSum<0)
           currentSum=0;


     }
     return maxSum;


    }



    public static int[] positionOfMaxSumSubArray(int[] a){

        int currentSum=0;
        int maxSum=0;
        int start=-1,end=-1;

        for(int i=0;i<a.length;i++){

            currentSum=currentSum+a[i];



            if(currentSum<=0) {
                currentSum = 0;
                start=i;
            }

            if(maxSum<currentSum) {
                maxSum = currentSum;
                end=i;
            }

        }
        return new int[]{start+1,end};

    }




}
