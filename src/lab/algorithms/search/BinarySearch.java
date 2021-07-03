package lab.algorithms.search;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class BinarySearch {

    public BinarySearch() {
        // TODO Auto-generated constructor stub
    }


    public static void main(String args[]) {

        int[] arr = {0, 1, 2, 3, 4};


        int indx=binarySearch(arr,5);

      //  int indx = binarySearchRecursive(arr, 8, 0, arr.length - 1);

        if (indx < 0) {
            System.out.println("Couldn't find");
        } else
            System.out.println("Found at " + indx);


    }


    //Returns position of key in sorted array a
    public static int binarySearch(int[] a, int key) {


        int start = 0, end = a.length - 1, mid;


        while (start <= end) {

            mid = (end + start) / 2;

            System.out.println(" Start:" + start + " Mid:" + mid + " End:" + end);
            if (key > a[mid]) {
                start = mid + 1;
            } else if (key < a[mid]) {
                end = mid - 1;
            } else if (key == a[mid]) {
                return mid;
            }
            System.out.println(" Start:" + start + " Mid:" + mid + " End:" + end);
            System.out.println("");
        }
        return -1;


    }


    public static int binarySearchRecursive(int[] a, int key, int start, int end) {


        if (a[start] == key) {
            return start;

        } else if (a[end] == key) {
            return end;
        } else {

            int mid = (start + end) / 2;

            if (key > a[mid]) {
                //The return is very important. Otherwise it'll go further down and return -1
                return binarySearchRecursive(a, key, mid + 1, end);

            } else if (key < a[mid]) {
                return binarySearchRecursive(a, key, start, mid - 1);
            } else if (key == a[mid]) {
                return mid;
            }

        }

        return -1;


    }


    public int binarySearchRotated(int[] a, int key) {

        return 0;

    }


}
