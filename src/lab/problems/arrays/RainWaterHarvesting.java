package lab.problems.arrays;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

https://leetcode.com/problems/trapping-rain-water/
 */

public class RainWaterHarvesting {
    public static void main(String[] args) {

  //Tests

        //5.
        int[] b ={2,4,7,1,9,0,4,2,5,0};
        System.out.println("b:"+calculateWaterArea(b));

   //1.
        int[] a ={1,0,5,1,3,0,4,0,0,3};
        System.out.println("a:"+calculateWaterArea(a));

  //2.   Worst case

       int[] worst ={10,9,8,7,6,5,4,3,2,1};
        System.out.println("worst:"+calculateWaterArea(worst));


   //3. Best case

        int[] best = {1,2,3,4,5,6,7,8,9};
        System.out.println("worst:"+calculateWaterArea(best));

    //4. Edge Cases

         int[] edge1= {};
        System.out.println("worst:"+calculateWaterArea(edge1));
         int[] edge2={1};
        System.out.println("worst:"+calculateWaterArea(edge2));



    }





    public static int calculateWaterArea(int[] a){

        int area=0;
        int leftIndex=0;
        int rightIndex=0;
       while(rightIndex<a.length-1){
           //We are looking for a value that is bigger than the current value, OR the largest of the remaining values
            //if no value is larger or equal.


         rightIndex = findNextBiggest(a,leftIndex+1,a[leftIndex]);
         area = area + calculateAreaBetween(a,leftIndex,rightIndex);

         leftIndex = rightIndex;

        }


       return area;



    }


    private static int findNextBiggest(int[] a,int start, int currentValue){
        //Returns the index of the next value which is greater than or equal.
        //If there are no values greater than or equal, return the biggest of all remaining values

        int maxIndex=start;
        for(int i=start;i<a.length;i++){
            if(a[i]>=currentValue)
                return i;

            if(a[i]>=a[maxIndex])
                maxIndex = i;

        }
        return maxIndex;

    }


   private static int calculateAreaBetween(int[] a,int start,int end){

        int area=0;
       int height=Math.min(a[start],a[end]);
        for(int i=start+1;i<end;i++){
            area = area + height - a[i];
        }

        return area;
   }



}
