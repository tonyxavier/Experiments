package lab.problems.twodarray;

import java.util.ArrayList;

public class MergeInterval {



    public static void main(String[] args) {
        MergeInterval inter = new MergeInterval();
        int[][] input ={{1,3},{2,6},{8,10},{15,18}};
        int[][] res=inter.mergeIntervals(input);

        for (int[] interval:res)
            System.out.println(interval[0]+" "+interval[1]);


    }


    public int[][] mergeIntervals(int[][] intervals){

        ArrayList<int[]> result = new ArrayList<>();


        for(int i=0;i<intervals.length-1;i++){

            int[] interval = intervals[i];
            int[] nextinterval =intervals[i+1];
            int[] newinterval =new int[2];

            if(interval[1]>=nextinterval[0]){
                newinterval[0]=interval[0];
                newinterval[1]=nextinterval[1];
                intervals[i]=null;
                intervals[i+1]=newinterval;
            }
        }


       return compressArray(intervals);


    }


    private int[][] compressArray(int[][] input){

        int length=0;
        for(int[] sub:input){
            if(sub!=null)
                length++;
        }

        int[][] result = new int[length][2];

        int j=0;
        for(int[] sub:input){
            if(sub!=null)
                result[j++]=sub;
        }

        return result;

    }

}
