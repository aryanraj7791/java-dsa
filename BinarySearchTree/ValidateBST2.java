import java.util.*;

public class ValidateBST2{

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

    public static Node inOrderPred(Node root){
        if(root == null){
            return null;
        }
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    public static Node inOrderSucc(Node root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static boolean isValid(Node root){ // TC->O(nh) where n-Total nodes and h-Height of tree
        if(root == null){
            return true;
        }
        Node inOrderPred = inOrderPred(root.left);
        Node inOrderSucc = inOrderSucc(root.right);
        if(inOrderPred != null && root.val <= inOrderPred.val) return false;
        if(inOrderSucc != null && root.val >= inOrderSucc.val) return false;
        return isValid(root.left) && isValid(root.right);
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
        if(isValid(root)){
            System.out.print("BST is valid");
        }else{
            System.out.print("BST is not valid");
        }
    }
}