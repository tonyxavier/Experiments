package lab.ds.tree;

public class MaxHeap {

    int[] heap;

    int next; //integer pointing to the next empty location


    MaxHeap(int capacity) {
        heap = new int[capacity];
        next = 0;
    }


    public static void main(String args[]) {

        MaxHeap h = new MaxHeap(100);

        h.insert(5);
        h.insert(15);
        h.insert(25);
        h.insert(35);
        h.insert(10);
        h.insert(45);
        h.insert(20);
        h.insert(60);
        h.insert(70);
        h.insert(50);


        h.traverse();


        h.heapSort();


        h.traverse();


    }


    public void heapSort() {

        while (next > 0) {

            System.out.println(deleteMax());

        }

    }

    public void insert(int n) {

        if (next >= heap.length) {
            System.out.println("Heap Overflow!!Can't insert");
            return;
        }

        heap[next++] = n;
        heapifyUp(next - 1);


    }


    private void heapifyUp(int last) {


        int parent = parent(last);
        if (parent < 0) {
            return;
        } else {
            if (heap[last] > heap[parent]) {
                int temp = heap[parent];
                heap[parent] = heap[last];
                heap[last] = temp;
                heapifyUp(parent);

            }

        }


    }

    public int deleteMax() {


        if (next == 0) {
            return -1;  //empty heap
        } else if (next == 1)//delete last element
        {
            next = 0;
            return heap[0];
        } else {

            int max = heap[0];
            heap[0] = heap[next - 1]; //bring the last element to the root
            next--;

            heapifyDown(0);

            return max;
        }

    }


    private void heapifyDown(int i) {

        int left = leftChild(i), right = rightChild(i);

        if (i >= next || (left >= next && right >= next)) {
            return;
        }


        int maxIndex = i;
        if (left < next && heap[left] > heap[i])
            maxIndex = left;

        if (right < next && heap[right] > heap[maxIndex])
            maxIndex = right;

        if (maxIndex != i)//if left or right is greater than parent, swap
        {

            swap(i, maxIndex);
            heapifyDown(maxIndex);

        }

    }

    private void swap(int i, int j) {

        int val = heap[i];
        heap[i] = heap[j];
        heap[j] = val;

    }


    private int leftChild(int i) {

        return 2 * i + 1;

    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }


    private int parent(int i) {

        return (i - 1) / 2;

    }

    public void traverse() {

        for (int i = 0; i < next; i++) {

            System.out.print(heap[i] + " ");
        }

    }


}
