package lab.design.designpatterns.creational.factorymethod;


/*

In a factory method pattern different type of objects are created in a factory class
which takes some parameter to decide what type of object needs to be created.
The factory class will have a static method that returns an object
The factory class will have a static method that returns an object

 */
public class HeapFactory {

    public static Heap buildHeap(boolean ascending, int[] input){

        if(ascending)
            return new MinHeap(input);
        else
            return new MaxHeap(input);

    }

}
