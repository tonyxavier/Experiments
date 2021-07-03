package lab.ds.list;

import java.sql.SQLOutput;

public class MultiLevelDoublyLinkedList  {
  Node head;

    private class Node{
        public Node prev,next,child;
        public Object data;

        public Node(Object value){
            data=value;
        }

    }

    public static void main(String[] args) {

        MultiLevelDoublyLinkedList dll = new MultiLevelDoublyLinkedList();

        dll.insert(dll.head, 5);
        dll.insert(dll.head, 4);
        dll.insert(dll.head, 3);
        dll.insert(dll.head, 2);
        dll.insert(dll.head, 1);
       // dll.insertAfter(dll.head, 3,6);
        dll.addChild(dll.head, 2,6);
        dll.insertAfter(dll.head, 6,7);
        dll.insertAfter(dll.head, 7,8);

        dll.addChild(dll.head, 8,9);
        dll.addChild(dll.head, 4,10);
        dll.addChild(dll.head, 5,11);
        dll.insertAfter(dll.head, 11,12);


        dll.traverseFlattened(dll.head);

        System.out.println("Before flatten:");
        dll.traverse();

        System.out.println("After flatten:");
        dll.flatten();
        dll.traverse();

    }


    public void insert(Node head, Object value){

        if(head==null) {
            this.head = new Node(value);
            return;
        }

        Node node = new Node(value);
        node.next = head;
        head.prev = node;
        this.head = node;

    }

    public boolean insertAfter(Node head,Object key,  Object value){

        if(head==null)
            return false;

        if(head.data.equals(key)){

            Node newnode = new Node(value);
            newnode.next = head.next;
            newnode.prev = head;

            if(head.next!=null)
                head.next.prev = newnode;

            head.next = newnode;

            return true;

        }

        if(!insertAfter(head.child,key,value)){
            return insertAfter(head.next,key,value);
        }
        else
         return true;


    }




    public boolean addChild(Node head, Object key, Object child){

        if(head ==null)
            return false;

        if(head.data.equals(key)){
            Node childNode =new Node(child);
            head.child = childNode;
            return true;
        }
        if(!addChild(head.child,key,child)){
            return addChild(head.next,key,child);
        }
        else
            return true;



    }


  public void traverseFlattened(Node head){

        if(head==null)
            return;

      System.out.println(head.data);
      traverseFlattened(head.child);
      traverseFlattened(head.next);

  }

  public void traverse(){

        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp =temp.next;

        }


  }



  public void flatten(){

        if(head==null)
            return;

        Node temp =head;

        Node currentNode =head;

        while(currentNode!=null) {

            while (currentNode.child == null && currentNode.next!=null) {
                currentNode = currentNode.next;
            }

            if(currentNode.next==null && currentNode.child==null) //last element
                return;


            Node nextnode = currentNode.next;
            currentNode.next = currentNode.child;
            currentNode.child.prev = currentNode;
            Node tail = getTailNode(currentNode.child);

            if(nextnode!=null)
               nextnode.prev=tail;

            tail.next = nextnode;

            currentNode = currentNode.next;

        }

  }


  private Node getTailNode(Node head){

        if(head==null)
            return null;

        Node temp=head;
        while(temp.next !=null || temp.child!=null){
            if(temp.next==null)
                temp=temp.child;
            else
               temp=temp.next;
        }
        return temp;

  }


}
