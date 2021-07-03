package lab.ds.list;

public class Runner {

    public Runner() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        list.traverse();


        System.out.println(list.nthFromLast(3));


    }

}
