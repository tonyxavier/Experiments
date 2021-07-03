package lab.ds.list;

public class DoublyLinkeList {
    private Node head,tail;

    private class Node{
        public Node prev,next;
        public Object data;

        public Node(Object value){
            data=value;
        }

    }

    public DoublyLinkeList() {

    }


    public static void main(String[] args) {

        DoublyLinkeList dll = new DoublyLinkeList();

        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);
        dll.append(6);
        dll.append(7);
        dll.append(8);
        dll.append(9);
        dll.append(10);

        dll.traverse();

    }


    public void insert(Object value){

        if(head==null) {
            head = new Node(value);
            tail = head;
            return;
        }

        Node node = new Node(value);
        node.next = head;
        head.prev = node;
        head = node;

    }

    public void append(Object value){

        if(head==null){
            head = new Node(value);
            tail = head;
            return;
        }

        Node node = new Node(value);
        node.prev = tail;
        tail.next = node;
        tail = node;

    }


    public void traverse(){

        Node temp= head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

}
