import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class balancedBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(TreeNode root,ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }

    public static TreeNode creatBST(ArrayList<Integer> inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = creatBST(inorder, st, mid-1);
        root.right = creatBST(inorder, mid+1, end);
        return root;
    }

    public static TreeNode balancedBST(TreeNode root){
        //inorder quence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted array -> balanced BST
        root = creatBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(3);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(12);

        root = balancedBST(root);
        preorder(root);

    }
}
