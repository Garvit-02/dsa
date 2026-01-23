public class sizeOfLargestBST {
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

    static class Info{
        int size;
        int max;
        int min;
        boolean isBST;

        Info(boolean isBST,int size,int min,int max){
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
    
    public static int maxSize = 0;
    public static Info largestBST(TreeNode root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int max = Math.max(root.val,Math.max(leftInfo.max,rightInfo.max));
        int min = Math.min(root.val,Math.min(leftInfo.min,rightInfo.min));

        if(leftInfo.max >= root.val || rightInfo.min <= root.val){
            return new Info(false,size,min,max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxSize = Math.max(maxSize,size);
            return new Info(true,size,min,max);
        }

        return new Info(false,size,min,max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);

        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        Info info = largestBST(root);
        System.out.println("Size of largest BST is : " + maxSize);
    }
}
