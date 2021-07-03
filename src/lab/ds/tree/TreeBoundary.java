package lab.ds.tree;

public class TreeBoundary {

    Node root;


    public static void main(String args[]) {

        int[] input = {30, 25, 60, 15, 10, 20, 50, 40, 70};

        TreeBoundary tree = new TreeBoundary();


        //inserts the numbers in the input array into the tree as a Binary Search Tree
		/*
		
		For the given array the tree will be as follows
		
		                           
		
		                    30
		                    
		               25         60
		                 
		            15          50    70
		             
		         10     20    40
		
		
		
		
		*/


        for (int i = 0; i < input.length; i++) {
            tree.insert(input[i]);
        }


        if (tree.root != null) {

            //Print all left most nodes (except leaves)
            tree.printLeftMostNodes(tree.root);


            //Print all leaves from left to right
            tree.printAllLeaves(tree.root);


            //Print all right most nodes except leaves
            tree.printRightMostNodes(tree.root.right);
        }


    }


    public void insert(int key) {

        Node newnode = new Node(key);


        if (root == null) {
            newnode.left = null;
            newnode.right = null;
            root = newnode;
            return;
        }


        Node parent;
        Node current = root;


        while (true) {

            parent = current;

            if (key < parent.key) {
                current = parent.left;

                if (current == null) {
                    parent.left = newnode;
                    return;
                }

                parent = current;

            } else {
                current = parent.right;

                if (current == null) {
                    parent.right = newnode;
                    return;
                }
                parent = current;

            }


        }//end of while


    }


    //Print all nodes in the left boundary except the leaf nodes
    public void printLeftMostNodes(Node node) {


        if (node == null)
            return;

        if (node.left != null) {
            System.out.println(node.key);
            printLeftMostNodes(node.left);

        } else if (node.right != null) //Go to the right subtree only if left subtree is null
        {
            System.out.println(node.key);
            printLeftMostNodes(node.right);
        }


    }


    public void printAllLeaves(Node node) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {

            System.out.println(node.key);
            return;
        }


        printAllLeaves(node.left);

        printAllLeaves(node.right);


    }


    public void printRightMostNodes(Node node) {


        if (node == null)
            return;


        if (node.right != null) {
            System.out.println(node.key);
            printRightMostNodes(node.right);

        } else if (node.left != null) {
            printRightMostNodes(node.left); //To keep the anti-clockwise order of nodes in the boundary print the deepest node first
            System.out.println(node.key);

        }


    }


}
