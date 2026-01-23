class BST{
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
    public static TreeNode insert(TreeNode root,int k){
        if(root == null){
            root = new TreeNode(k);
            return root;
        }
        if(k<root.val){
            root.left = insert(root.left,k);
        }else if(k>root.val){
            root.right = insert(root.right,k);
        }
        return root;
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int values[] ={5,1,3,4,2,7};
        TreeNode root = null;
        for(int i =0; i<values.length;i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
    }
}