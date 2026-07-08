import java.util.*;

public class KthAncestor{

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int []nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public int kthAncestor(Node root, int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int leftAns = kthAncestor(root.left,n,k);
            int rightAns = kthAncestor(root.right,n,k);
            if(leftAns == -1 && rightAns == -1){
                return -1;
            }else if(leftAns == -1){
                if(rightAns+1 == k){
                    System.out.print("Kth ancestor of "+n+" is : "+root.data);
                }
                return rightAns+1;
            }else{
                if(leftAns+1 == k){
                    System.out.print("Kth ancestor of "+n+" is : "+root.data);
                }
                return leftAns+1;
            }
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = scn.nextInt();
        int []nodes = new int[n];
        System.out.println("Enter value of nodes : ");
        for(int i=0; i<nodes.length; i++){
            nodes[i] = scn.nextInt();
        }
        System.out.print("Enter node value : ");
        int n1 = scn.nextInt();
        System.out.print("Enter k : ");
        int k = scn.nextInt();
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        bt.kthAncestor(root,n1,k);
    }
}