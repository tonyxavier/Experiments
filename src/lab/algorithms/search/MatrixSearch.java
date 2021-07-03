package lab.algorithms.search;



//The matrix contains just 0 or 1. Each row is individually soreted. Find the  position where the first 1 appears from left

public class MatrixSearch {

    public static void main(String[] args) {

        int[][] a = {
                {0,0,0,1,1,1,1},
                {0,0,0,1,1,1,1},
                {0,0,0,0,0,1,1},
                {0,0,1,1,1,1,1},
                {0,0,0,1,1,1,1}

                     };


        int[] res=findLeftMostNonero(a);
        System.out.println(res[0]+" "+res[1]);

    }


    public static int[] findLeftMostNonero(int[][] a){

        int start=0,end=a.length-1,mid;

        while(start <= end){

            mid=(start+end)/2;
            System.out.println(" Start:" + start + " Mid:" + mid + " End:" + end);
            int nzindex=indexOfFirstNonZero(a,mid);
            System.out.println("Indx:"+nzindex);

            if(nzindex!=-1 && start==mid){
                return new int[]{nzindex,mid};
            }
            else if(nzindex!=-1 && start!=mid){
                end=mid;
            }
            else if(nzindex==-1){
               start=mid+1;
            }
            else {
                System.out.println("Some misterious condition");
            }



        }

        return null;
    }




    private static int indexOfFirstNonZero(int[][]a,int col){

        for(int i=0;i<a.length;i++) {
            if (a[i][col] != 0)
                return i;
        }
        return -1;
        }

    }


