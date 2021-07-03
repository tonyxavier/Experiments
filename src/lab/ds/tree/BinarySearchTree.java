package lab.ds.tree;

public class BinarySearchTree {
    Node root;


    public void insert(int key, Object data) {

        Node newnode = new Node(key);
        newnode.data = data;

        if (root == null) {
            newnode.left = null;
            newnode.right = null;
            root = newnode;
            return;
        }


        Node parent;
        Node current = root;
        ;


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


    public void preorderTraverse(Node root) {

        if (root == null)
            return;

        System.out.println(root.key);
        preorderTraverse(root.left);
        preorderTraverse(root.right);

    }

    public void inorderTraverse(Node root) {


        if (root == null)
            return;

        inorderTraverse(root.left);
        System.out.println(root.key);
        inorderTraverse(root.right);


    }


    public void postorderTraverse(Node root) {


        if (root == null)
            return;

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.println(root.key);


    }


    public static void main(String args[]) {


        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(15, "Fifteen");

        bst.insert(9, "Nine");

        bst.insert(25, "TwentyFive");

        bst.insert(7, "Seven");

        bst.insert(35, "ThirtyFive");


         bst.preorderTraverse(bst.root);

        System.out.println("");
         bst.inorderTraverse(bst.root);



        System.out.println("");
        bst.postorderTraverse(bst.root);
    }


}



