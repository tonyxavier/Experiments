package lab.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder extends BinaryTree{


    public static void main(String[] args) {

        LevelOrder tree =new LevelOrder();

        tree.buildTree();

       // System.out.println("levelOrderTraversalRecursive");
      //  tree.levelOrderTraversalRecursive(tree.getRoot());

        System.out.println("zigZagTraversal");
        tree.zigZagTraversal(tree.getRoot());

      //  System.out.println("levelOrderOptimized");
       // List<List<Integer>> levels = tree.levelOrderOptimized(tree.getRoot());

        /*
        for(List<Integer> level : levels){
            System.out.println("");
            for (Integer val: level)
                System.out.print(val+" ");
        }
        */



        tree.rightSideView(tree.getRoot());



    }


    //Simple level order traversal cannot keep track of which level an element belongs to
    // A counter is required to keep track of begenning of a new level

    public void buildTree() {

        Node newnode = new Node(9);
        createTree(newnode);


        insertLeft( 9, 4);
        insertRight( 9, 8);
        insertLeft( 4, 7);
        insertRight( 4, 6);
        insertLeft( 6, 16);
        insertLeft( 8, 2);
        insertLeft( 2, 5);
        insertRight( 5, 1);
        insertLeft( 5, 3);



    }





    public List<List<Integer>> levelOrderOptimized(Node root){

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        int lenght=queue.size();
        int counter =0;
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<>();
        int levelnum=1;
        while (!queue.isEmpty()){

            Node current = queue.poll();
            level.add(current.key);
            counter++;

            //System.out.println(current.key);

            if(current.left!=null)
                queue.add(current.left);

            if(current.right!=null)
                queue.add(current.right);

            if(counter==lenght){
                levels.add(level);
                System.out.println("Lvelcount:"+levelnum++);

                level = new ArrayList<Integer>();
                counter=0;
                lenght= queue.size();
            }


        }
        return levels;

    }





    //O(n^2)
    public void levelOrderTraversalRecursive(Node tree) {


        int h = height(tree);

        boolean lleft2Right = true; //Flag to allow ZIG ZAG order traversal

        for (int i = 1; i <= h; i++) {
            traverseSingleLevel(tree, i, lleft2Right);
            System.out.println();
            // lleft2Right=!lleft2Right; //flip the flag after each level so that the traversal is ZIG ZAG

        }


    }


    public void zigZagTraversal(Node tree){


        int h = height(tree);

        boolean lleft2Right = true; //Flag to allow ZIG ZAG order traversal

        for (int i = 1; i <= h; i++) {
            traverseSingleLevel(tree, i, lleft2Right);
            System.out.println();
            lleft2Right=!lleft2Right; //flip the flag after each level so that the traversal is ZIG ZAG

        }


    }


    //Which all nodes are visible to a person standing on the right side of the tree - only the right mose nodes at each level
    public void rightSideView(Node root){

        List<List<Integer>> levels = levelOrderOptimized(root);

        int l=1;
        for(List<Integer> level:levels){
            int lastIndex = level.size()-1;
            System.out.println("At level "+l+" "+ level.get(lastIndex));

        }

    }




    //
    public void traverseSingleLevel(Node root, int level, boolean left2Right) {

        if (root != null) {
            if (level < 1) {
                return;
            } else if (level == 1) {

                System.out.print(root.key + " ");

            } else {
                if (left2Right) {
                    traverseSingleLevel(root.left, level - 1, left2Right);
                    traverseSingleLevel(root.right, level - 1, left2Right);
                } else {
                    traverseSingleLevel(root.right, level - 1, left2Right);
                    traverseSingleLevel(root.left, level - 1, left2Right);
                }


            }

        }

    }


}
