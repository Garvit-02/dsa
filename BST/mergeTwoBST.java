import java.util.ArrayList;

public class mergeTwoBST {
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
    public static void getInorder(TreeNode root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.val);
        getInorder(root.right, arr);
    }
    public static TreeNode createBST(ArrayList<Integer> arr,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static TreeNode merge(TreeNode root1,TreeNode root2){
        //step1 
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2,arr2);

        //step2 - merge 2 sorted array
        ArrayList<Integer> finalarr = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }else{
                finalarr.add(arr2.get(j));
                j++;
            }
        }

        while ((i<arr1.size())){
            finalarr.add(arr1.get(i));
            i++;
        } 
        while ((j<arr2.size())){
            finalarr.add(arr2.get(j));
            j++;
        }

        //step3 - sorted array -> balanced BST
        return createBST(finalarr, 0, finalarr.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(9);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(12);

        TreeNode root = merge(root1, root2);
        preorder(root);
    }
}
