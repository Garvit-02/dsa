// package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Basic {
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

    static class BinaryTree{
        static int idx =-1;
        public static Node buildTree(int node[]){ // TC O(N)
            idx++;
            if(node[idx] == -1){
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;
        }

        // PreOrder Traversal
        public static void preOrder(Node root){  // TC = O(N)
            if(root == null){
                // System.out.print("-1" +" "); used when we also want to print -1 like in dataset we have given
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //In-order Traversal
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        //Post-order Traversal
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data + " ");
        }

        //level order traversal
        // Important Question used in many interviews

        
    }
    public static void main(String args[]){
        int node[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();

        // Build the tree from the array
        Node root =tree.buildTree(node);
        //System.out.println(root.data);

        //Pre-order Traversal
        tree.preOrder(root);
        System.out.println();

        //In-order Traversal
        tree.inOrder(root);
        System.out.println();

        //Post-order Traversal
        tree.postOrder(root);
        System.out.println();

        //Level-order Traversal
        tree.levelOrder(root);
    }
}
