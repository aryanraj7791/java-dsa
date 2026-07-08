import java.util.*;

public class SortedArrayToBalancedBST{

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
        if(root.val > val){
            root.left = buildBST(root.left,val);
        }else{
            root.right = buildBST(root.right,val);
        }
        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node balancedBST(int []arr, int si, int ei){ //TC-O(n)
        if(si > ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr,si,mid-1);
        root.right = balancedBST(arr,mid+1,ei);
        return root;
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
        Node balancedRoot = balancedBST(nodes,0,nodes.length-1);
        preOrder(balancedRoot);
    }
}