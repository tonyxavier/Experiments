package lab.problems.arrays;

//You are given an array of integers. Input is a sum and you have to find the elements in the array that add up to the sum

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbersThatAddUptoSum {

    public static void main(String[] args) {

int[] a ={3,5,6,7,9,1};

       int[] res= findNumbersThatAddUptoSum(a,4);

        System.out.println("1st:"+res[0]+ " 2nd:"+res[1]);

    }



    public static int[] findNumbersThatAddUptoSum(int[]a,int sum){
        Map<Integer, Integer> nums = new HashMap<>();
        for(int i=0;i<a.length;i++)
            nums.put(a[i],i);

        for(int i=0;i<a.length;i++){
            Integer index = nums.get(sum-a[i]);
            if(index!=null && index!=i)
                return new int[]{i,index};
        }

        return null;

    }



}
