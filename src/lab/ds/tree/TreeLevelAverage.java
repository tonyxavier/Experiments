package lab.ds.tree;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;


public class TreeLevelAverage {

    Node root;
    HashMap<Integer, LevelSum> avg = new HashMap<>();

    public static void main(String args[]) {

        TreeLevelAverage tree = new TreeLevelAverage();

        tree.buildBinaryTree();

        // tree.breadthFirst();

      //  int height = tree.heightOfTree(tree.root);

     //   System.out.println(height);

        tree.levelAvg(tree.root,0);

       for(int i=0;i<=3;i++){

           LevelSum sum=tree.avg.get(i);
           System.out.println("Level:"+i+" Avg:"+sum.sum/sum.count);

       }


    }

    public void buildBinaryTree() {

        //level 3
        Node temp1 = createRoot(3);
        Node temp2 = createRoot(2);
        Node temp3 = createRoot(15);
        Node temp4 = createRoot(3);

        //level2:
        Node temp5 = createRoot(4);
        Node temp6 = createRoot(6);
        Node temp7 = createRoot(2);
        Node temp8 = createRoot(14);

        temp6.left = temp1;
        temp6.right = temp2;

        temp8.left = temp3;
        temp8.right = temp4;

        Node temp9 = createRoot(3);
        Node temp10 = createRoot(9);

        temp9.right = temp6;
        temp9.left = temp5;
        temp10.right = temp8;
        temp10.left = temp7;

        Node temp11 = createRoot(7);
        temp11.left = temp9;
        temp11.right = temp10;

        this.root = temp11;

    }


    private void breadthFirst() {

        Queue<Node> queue = new LinkedList<Node>();


        queue.add(root);

        while (!queue.isEmpty()) {


            Node current = queue.poll();
            System.out.println(current.key);

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);


        }


    }

    private int heightOfTree(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));

    }


    private void levelAvg(Node root, int depth) {


        if (root == null)
            return;

        LevelSum levelsum = avg.get(depth);

        if(levelsum==null) {
            levelsum = new LevelSum();
            levelsum.sum=root.key;
            levelsum.count =1;

        }
        else{
            levelsum.sum=levelsum.sum+root.key;
            levelsum.count=levelsum.count+1;


        }
        avg.put(depth,levelsum);

        levelAvg(root.left,depth+1);
        levelAvg(root.right,depth+1);


    }







    private Node createRoot(int n){

        Node r = new Node(n);

        return r;


    }



    private class LevelSum{
        int sum,count;


        public void show(){
            System.out.println("Sum:"+sum+ "  Count:"+count);
        }
    }


}
