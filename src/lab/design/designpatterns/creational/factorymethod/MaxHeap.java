package lab.design.designpatterns.creational.factorymethod;

public class MaxHeap implements Heap{

 public MaxHeap(int[] input){
     System.out.println("Building MaxHeap");
 }

 public void sort(){
     System.out.println("Sorting from Max to Min");
 }


}
