package lab.ds.tree;

public class MaximumPathSum extends BinaryTree {

    int maxSum=Integer.MIN_VALUE;

    public static void main(String[] args) {

        MaximumPathSum tree =new MaximumPathSum();

        tree.buildTree();
        tree.maximumPathSum(tree.getRoot());

        System.out.println("MaxPathSum:"+ tree.maxSum);


    }


    public int maximumPathSum(Node root){

        if(root==null)
            return 0;

        int leftWeight=Math.max(maximumPathSum(root.left),0);
        int rightWeight = Math.max(maximumPathSum(root.right),0);
        int weightOfPathThroughThisNode =root.key + leftWeight + rightWeight;
        maxSum = Math.max(maxSum, weightOfPathThroughThisNode);
        return root.key + Math.max(leftWeight,rightWeight);

        }


    public void buildTree() {


/*
        //Test 1 . Path not through root
        Node newnode = new Node(-10);
        createTree(newnode);
        insertLeft( -10, 9);
        insertRight( -10, 20);
        insertLeft( 20, 15);
        insertRight( 20, 7);

*/


        //Test 2 . Path  through root
        Node newnode = new Node(10);
        createTree(newnode);
        insertLeft( 10, 9);
        insertRight( 10, 20);
        insertLeft( 20, 15);
        insertRight( 20, 7);

    }



}

