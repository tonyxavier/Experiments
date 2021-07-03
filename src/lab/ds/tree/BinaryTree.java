package lab.ds.tree;

import java.util.Stack;

//Just a binary tree that does not assume any ordering of elements
public class BinaryTree {

    private Node root;

    public Node getRoot(){
        return root;
    }

    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();

        tree.buildTree();

        System.out.println("preOrderTraversal");
       	tree.preOrderTraversal(tree.root);

        //	tree.preOrderIterative(tree.root);

        //	tree.inorderTraversal(tree.root);


        //tree.inorderIterative(tree.root);
        System.out.println("postOrderTraversal");
        tree.postOrderTraversal(tree.root);

        System.out.println("postOrderTraversalIterative_2Stacks");
        tree.postOrderTraversalIterative_2Stacks(tree.root);



        //	tree.preOrderTraversal(tree.root);


    }


    public void buildTree() {

        Node newnode = new Node(1);
        createTree(newnode);


        insertLeft( 1, 2);
        insertRight( 1, 3);
        insertLeft( 2, 4);
        insertRight( 2, 5);
        insertLeft( 3, 6);
        insertRight( 3, 7);
        insertLeft( 4, 8);
        insertRight( 4, 9);
        insertLeft( 5, 10);
        insertRight( 5, 11);


    }




    //This method returns the number of nodes in the longest path
    //If number of edges is required, need to write a wrapper method and subtract 1 from the final height
    public int height(Node tree) {

        if (tree == null) {
            return 0;
        } else {

            return 1 + Math.max(height(tree.left), height(tree.right));

        }


    }


    public void preOrderTraversal(Node tree) {

        if (tree != null) {

            System.out.print(tree.key + " ");
            preOrderTraversal(tree.left);
            preOrderTraversal(tree.right);

        }


    }


    public void preOrderIterative(Node tree) {

        if (tree == null)
            return;


        Stack<Node> stack = new Stack<Node>();

        stack.push(tree);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.key + " ");

            if (temp.right != null)
                stack.push(temp.right);

            if (temp.left != null)
                stack.push(temp.left);


        }


    }


    public void inorderTraversal(Node tree) {

        if (tree == null)
            return;


        inorderTraversal(tree.left);
        System.out.print(tree.key + " ");
        inorderTraversal(tree.right);


    }


    public void inorderIterative(Node node) {

        if (node == null)
            return;


        Stack<Node> stack = new Stack<Node>();

        while (node != null) {
            stack.push(node);
            node = node.left;

        }

        while (!stack.isEmpty()) {

            Node current = stack.pop();

            System.out.print(current.key + " ");

            if (current.right != null) {
                current = current.right;

                while (current != null) {
                    stack.push(current);
                    current = current.left;

                }


            }


        }


    }


    public void postOrderTraversal(Node tree) {

        if (tree == null)
            return;


        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
        System.out.print(tree.key + " ");


    }


    /*
     * Observation - A modified pre-order traversal visits the nodes in the
     * reverse order of post-order traversal. So reversing the result of this
     * modified pre-order traversal results in post order traversal.
     *
     * The modification in pre-order traversal is that right node has to be
     * visisted before left node.   *
     *
     *
     */
    public void postOrderTraversalIterative_2Stacks(Node tree) {

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        if (tree == null)
            return;


        s1.push(tree);

        Node current = tree;

        while (!s1.isEmpty()) {

            current = s1.pop();
            s2.push(current);


            if (current.left != null) {
                s1.push(current.left);
            }


            if (current.right != null) {
                s1.push(current.right);
            }


        }

        while (!s2.isEmpty()) {
            Node temp = s2.pop();

            System.out.print(temp.key + " ");


        }


    }



    public Node preOrderSearch(Node tree, int key) {

        if (tree == null)
            return null;
        else {

            if (key == tree.key) {
                return tree;
            } else {
                Node found = null;

                found = preOrderSearch(tree.left, key);

                if (found == null)//if the key was not found in the left subtree
                {
                    found = preOrderSearch(tree.right, key);
                }

                return found;

            }


        }


    }


    public void createTree(Node newnode) {
        root = newnode;
    }


    public void insertLeft(int key, int leftChild) {

        Node temp = preOrderSearch(root, key);

        if (temp == null) {

            System.out.println("No such node exists in the tree");

        } else {


            temp.left = new Node(leftChild);

        }


    }


    public void insertRight(int key, int rightChild) {

        Node temp = preOrderSearch(root, key);

        if (temp == null) {

            System.out.println("No such node exists in the tree");

        } else {

            temp.right = new Node(rightChild);

        }


    }




}
