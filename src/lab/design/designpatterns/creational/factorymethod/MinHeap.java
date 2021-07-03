package lab.design.designpatterns.creational.factorymethod;

public class MinHeap implements Heap{

    public MinHeap(int[] input){
        System.out.println("Building MinHeap");
    }

    public void sort(){
        System.out.println("Sorted from Min");
    }


}
