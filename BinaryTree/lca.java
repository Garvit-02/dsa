package BinaryTree;

import java.util.ArrayList;

public class lca {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // lowest common ancestor
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // base case
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if (foundLeft || foundRight) {
            return true;
        }

        // if not found in either subtree, remove the node from the path and return
        // false
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) { // TC,SC = O(N)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        boolean found1 = getPath(root, n1, path1);
        boolean found2 = getPath(root, n2, path2);
        if (!found1 || !found2) {
            return null; // One of the nodes is not present
        }

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    //Optimized approach - TC = O(N),SC = O(1)
    public static Node lca2(Node root, int n1 , int n2) {
        if(root == null|| root.data == n1|| root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);
        if(leftLca == null) {
            return rightLca;
        }
        if(rightLca == null) {
            return leftLca;
        }

        return root;
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, 4, 5).data);
        System.out.println(lca2(root, 4, 5).data);

    }
}
