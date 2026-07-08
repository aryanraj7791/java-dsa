import java.util.*;

public class ValidateBST1{

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

    public static boolean isValid(Node root, Node min, Node max){ //TC-> O(n)
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }else if(max != null && root.val >= max.val){
            return false;
        }else{
            return isValid(root.left,min,root) && isValid(root.right,root,max);
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = scn.nextInt();
        int []nodes = new int[n];
        System.out.println("Enter nodes value : ");
        for(int i=0; i<nodes.length; i++){
            nodes[i] = scn.nextInt();
        }
        Node root = null;
        for(int i=0; i<nodes.length; i++){
            root = buildBST(root,nodes[i]);
        }
        if(isValid(root,null,null)){
            System.out.print("Valid BST");
        }else{
            System.out.print("Invalid BST");
        }
    }
}