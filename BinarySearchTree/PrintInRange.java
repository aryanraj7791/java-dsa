import java.util.*;

public class PrintInRange{

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val < val){
            root.right = buildBST(root.right,val);
        }else{
            root.left = buildBST(root.left,val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.val >= k1 && root.val <= k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.val+" ");
            printInRange(root.right,k1,k2);
        }else if(root.val > k2){
            printInRange(root.left,k1,k2);
        }else{
            printInRange(root.right,k1,k2);
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes in tree : ");
        int n = scn.nextInt();
        int nodes[] = new int[n];
        System.out.println("Enter nodes value : ");
        for(int i=0; i<nodes.length; i++){
            nodes[i] = scn.nextInt();
        }
        Node root = null;
        for(int i=0; i<nodes.length; i++){
            root = buildBST(root,nodes[i]);
        }
        System.out.print("Enter k1 : ");
        int k1 = scn.nextInt();
        System.out.print("Enter k2 : ");
        int k2 = scn.nextInt();
        inOrder(root);
        System.out.println();
        printInRange(root,k1,k2);
    }
}