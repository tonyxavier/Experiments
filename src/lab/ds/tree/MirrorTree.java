package lab.ds.tree;

public class MirrorTree extends BinaryTree{


    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();

        tree.buildTree();

        tree.mirror(tree.getRoot());




    }

    //Generate the mirror image of a tree
    public Node mirror(Node node) {


        if (node == null)
            return null;
        else {
            Node temp1, temp2;

            temp1 = mirror(node.left);
            temp2 = mirror(node.right);

            node.left = temp2;
            node.right = temp1;

            return node;

        }


    }

}
