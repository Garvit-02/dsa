public class mirrorBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode createMirror(TreeNode root) {
        if (root == null)
            return null;

        TreeNode leftMirrorNode = createMirror(root.left);
        TreeNode rightMirrorNode = createMirror(root.right);

        root.left = rightMirrorNode;
        root.right = leftMirrorNode;
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

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }
        root = createMirror(root);
        preorder(root);
    }

    // Helper function to insert nodes in BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}
