// Previouslly asked in Amazon, Microsoft, and Google interviews and solve using BFS
package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.Basic.BinaryTree;

public class levelOrderTraversal {
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
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int node[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        // Build the tree from the array
        Node root =buildTree(node);
        levelOrder(root);
    }
}
