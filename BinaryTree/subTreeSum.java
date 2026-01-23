import org.w3c.dom.Node;

public class subTreeSum {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int subTreeSum(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = subTreeSum(root.left);
        int rightChild = subTreeSum(root.right);

        int newLeft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;
        int data = root.data;
        root.data = leftChild + newLeft + rightChild + newright;
        return data;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.err.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        subTreeSum(root);
        preorder(root);
    }
}
