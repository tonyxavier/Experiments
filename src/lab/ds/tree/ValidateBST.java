package lab.ds.tree;

public class ValidateBST extends BinaryTree{

    public static void main(String[] args) {

        ValidateBST tree = new ValidateBST();

        tree.buildTree();

        System.out.println(tree.isBSTValid(tree.getRoot(),Integer.MIN_VALUE,Integer.MAX_VALUE));

        tree.inorderTraversal(tree.getRoot());

    }




@Override
public void buildTree(){

        Node temp = new Node(18);
       createTree(temp);

       insertLeft(18,13);
       insertLeft(13,7);
       insertLeft(7,4);

       insertRight(13,17);
       insertRight(7,9);

       insertRight(18,23);
       insertRight(23,27);

       insertLeft(23,19);
       insertLeft(9,8);


}


    public boolean isBSTValid(Node root, int min, int max){

        if(root==null)
            return true;

        if(root.key>max || root.key<min)
            return false;

        if(root.left!=null){
            if(!isBSTValid(root.left,min,root.key))
                return false;

        }

        if(root.right!=null){
            if(!isBSTValid(root.right,root.key,max))
                return false;
        }

        return true;

    }


}
