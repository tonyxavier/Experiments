package lab.problems.arrays;

public class MoveNegativeToLeft {

    public static void main(String[] args) {
        int[] arr = {2, -1, 0, 5, -4, -23, 54, 9, 0};

        moveNegative(arr);
    }


    private static int[] moveNegative(int[] arr) {

        int i = 0, j = arr.length - 1;

        while (i < j) {

            while (arr[i] < 0)
                i++;

            while (arr[j] >= 0)
                j--;

            if(i>=j)
                break;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;



        }


        return arr;

    }
}
