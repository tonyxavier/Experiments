package lab.ds.tree;

public class ClosestBSTValue extends BinarySearchTree{

    public static void main(String[] args) {

        ClosestBSTValue bst = new ClosestBSTValue();

        bst.insert(15, "Fifteen");

        bst.insert(9, "Nine");

        bst.insert(25, "TwentyFive");

        bst.insert(7, "Seven");

        bst.insert(35, "ThirtyFive");

        bst.inorderTraverse(bst.root);

        int val = bst.closestBSTValue(bst.root,33);
        System.out.println(val);


    }

    public int closestBSTValue(Node root, double target){

        if(root==null)
            return Integer.MIN_VALUE;

        double v1 = Math.abs(root.key - target);
        double v2 = 10000000000.0;
        double v3 = 10000000000.0;


        if(root.left==null && root.right==null)
            return root.key;


        if(root.left!=null)
            v2= Math.abs(root.left.key-target);

        if(root.right!=null)
            v3=Math.abs(root.right.key-target);

        if(v1<v2 && v1<v3)
            return root.key;
        else if(v2 < v3 && root.left!=null)
            return closestBSTValue(root.left,target);
        else if(v3 < v2 && root.right!=null)
            return closestBSTValue(root.right,target);

     return Integer.MIN_VALUE;
    }

}
