package lab.algorithms.sorting;

public class KthLargest {


    public static void main(String[] args) {
        KthLargest algo = new KthLargest();

      //Test1
       // int[] input={4,8,7,1,3,9};


     //Test2
        int[] input={1,1,2,3,3,4};



          int num = algo.findKthLargest(input,5);
        System.out.println("Kth num:"+input[num]);



        for (int i : input) {
            System.out.print(i + " ");
        }


    }

    public  int findKthLargest(int[] input,int k){

        if(k<0 || k>=input.length)
            return -1;

        int start=0,end=input.length-1;
        int indexOfPivot=partition(input, start, end);
        while(indexOfPivot!=k) {
             if (indexOfPivot < k) {
                 start = indexOfPivot + 1;
                 indexOfPivot = partition(input, start, end);
             }
             else if (indexOfPivot > k) {
                 end=indexOfPivot - 1;
                 indexOfPivot = partition(input, start, end);
             }
            }
          return indexOfPivot;
        }


    private int partition(int[] input,int start,int end){


        int pivotIndex = getPivotIndex(input,start,end);
        int pivot =input[pivotIndex];
        int i=start,j=end;
        while(i<=j){

            while(i<j && input[i]<pivot )
                 i++;

            while(i<j && input[j]>=pivot)
                j--;


            if(i<j)
                swap(input, i, j);


            if(i==j ) {
                swap(input, i, pivotIndex);
                return i;
            }

        }
         return i;

    }



    private int getPivotIndex(int[] input,int start,int end){

        return end;

    }

    private void swap(int[] input,int i,int j){

        int temp = input[i];
        input[i]=input[j];
        input[j]=temp;


    }



}
