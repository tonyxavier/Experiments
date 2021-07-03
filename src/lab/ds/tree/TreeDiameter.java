package lab.ds.tree;

public class TreeDiameter extends BinaryTree {


    public static void main(String args[]) {

        TreeDiameter tree = new TreeDiameter();

        tree.buildTree();

        System.out.println(tree.diameter(tree.getRoot()));


    }

    //Diameter is the longest path from any two nodes in the tree
    public int diameter(Node root) {

        if (root == null)
            return 0;


        int lheight = height(root.left) - 1;//1 is subtracted to make it the number of edges instead of number of nodes
        int rheight = height(root.right) - 1;

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);


        return Math.max(lheight + rheight + 2, Math.max(ldiameter, rdiameter));


    }




}
