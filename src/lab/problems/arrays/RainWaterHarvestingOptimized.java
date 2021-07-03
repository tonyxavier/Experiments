package lab.problems.arrays;

public class RainWaterHarvestingOptimized {

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


        int leftPtr=0;
        int rightPtr=a.length-1;
        int area=0;
        int i=1;
        int j=a.length-2;
        while(leftPtr<rightPtr){


            if(a[leftPtr]<a[rightPtr]){

                while (a[i]<a[leftPtr])
                    i++;

                area = area + calculateAreaBetween(a,leftPtr,i);
                leftPtr=i;
                i++;
            }
            else {

                while(a[j]<a[rightPtr])
                    j--;

                area = area + calculateAreaBetween(a,j,rightPtr);
                rightPtr=j;
                j--;
            }



        }

        return  area;



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
