package lab.algorithms.sorting;

public class Sorting {

    public static void main(String args[]) {
        int[] a1 = {4, 19, 16, 10, 12, 7, 5, 8, 10, 13, 12, 3, 9};

        Sorting sort = new Sorting();

        // int[] b=sort.insertionSort(a);

        // int[] b=sort.mergeSort(a,0,a.length-1);

        // int[] b=sort.sort123(a);
/*
        sort.quickSort(a1, 0, a1.length - 1);

        for (int i : a1) {
            System.out.print(i + " ");
        }

 */

        int[] a2={4,8,7,1,3,9};
        sort.quickSort(a2, 0, a2.length - 1);

        for (int i : a2) {
            System.out.print(i + " ");
        }


    }


    public int[] selectionSort(int[] input) {


        return null;
    }


    /*
     *
     *
     *
     *
     *
     */

    public int[] insertionSort(int[] input) {
        int i, j = 0, x = 0;
        for (i = 0; i < input.length; i++) {
            j = i;
            while (j > 0 && input[j - 1] > input[j]) {

                x = input[j - 1];
                input[j - 1] = input[j];
                input[j] = x;

                j--;

            }
        }


        return input;

    }

    public int[] bubbleSort(int[] input) {

        return null;
    }

    public void quickSort(int[] input, int lo, int hi) {

        if (lo >= hi || lo<0 || hi>=input.length)
            return;

        // int p=partition_Hoare(input,lo,hi);

        int p = partition_Lomuto(input, lo, hi);


        quickSort(input, lo, p - 1);
        quickSort(input, p + 1, hi);


    }


    //used by Quicksort
    private int partition_Hoare(int[] input, int lo, int hi) {



        int pivot = input[hi];
        int i = lo;
        int j = hi - 1;

        while (true) {

            while (i<=hi && input[i] < pivot) {
                i++;
            }

            while (j >= lo && input[j] > pivot) {
                j--;
            }


            if (i < j)
                swap(input, i, j);

            if (i >= j) {
                swap(input, i, hi);
                return i;
            }


        }


    }


    //used by Quicksort
    private int partition_Lomuto(int[] input, int lo, int hi) {
        int pivot = input[hi];
        int i = lo, j = lo;

        while (j <= hi - 1) {

            if (input[j] < pivot) {
                swap(input, i, j);
                i++;
            }
            j++;


        }
        swap(input, i, hi);


        return i;
    }


    private void swap(int[] input, int i, int j) {

        if (i == j)
            return;

        int temp = input[i];

        input[i] = input[j];
        input[j] = temp;

    }

    public int[] mergeSort(int[] a, int low, int high) {

        if (low < high) {

            int mid = (low + high) / 2;

            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);

            merge(a, low, mid, high);


        }


        return a;
    }


    private void merge(int[] arr, int low, int mid, int high) {

        //Find size of subarray

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int leftSubArr[] = new int[n1];
        int rightSubArr[] = new int[n2];

        //fill subarrays
        for (int i = 0; i < n1; i++) {
            leftSubArr[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            rightSubArr[j] = arr[mid + 1 + j];
        }


        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {

            if (leftSubArr[i] < rightSubArr[j]) {
                arr[k++] = leftSubArr[i++];
            } else {
                arr[k++] = rightSubArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftSubArr[i++];
        }

        while (j < n2) {

            arr[k++] = rightSubArr[j++];

        }

    }


    public int[] heapSort(int[] input) {


        return null;
    }


    //sort an array having just 1s,2s and 3s. Inplace, O(n)
    public int[] sort123(int[] a) {

        int lo = 0, mid = 0, hi = a.length - 1;

        while (mid < hi) {

            switch (a[mid]) {

                case 0:
                    a[mid++] = a[lo];
                    a[lo++] = 0;
                    break;

                case 1:
                    mid++;
                    break;
                case 2:
                    a[mid] = a[hi];
                    a[hi--] = 2;
                    break;

            }


        }


        return a;
    }


}
