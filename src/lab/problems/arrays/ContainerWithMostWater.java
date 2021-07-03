package lab.problems.arrays;

/*


You are given an array of positive integers where each integer represents the hight of a vertical line on a chart
Find 2 lines together with the x-axis forms a container that would hold the greatest amount of water.
Return the area of water it would hold.
 */


public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] a={4,2,8,12,7,1,5,10,3,9};
        System.out.println(calculateMaximumPosbleArea(a));

    }



    public static int calculateMaximumPosbleArea(int[]arr){

        int a=0,b=arr.length-1;
        int max_area=0;
        while(a<b){
            max_area=Math.max(max_area,(b-a)*Math.min(arr[a],arr[b]));

            if(arr[a]<arr[b])
                a++;
            else
                b--;

        }

        return max_area;

    }






}
