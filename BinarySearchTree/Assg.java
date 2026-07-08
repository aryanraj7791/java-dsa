import java.util.*;

public class Assg{

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

    public static int minDiff(Node root, int target, int min){
        if(root == null){
            return min;
        }
        min = Math.min(Math.abs(root.val-target),min);
        if(min == 0) return 0;
        if(root.val>target){
            return minDiff(root.left,target,min);
        }else{
            return minDiff(root.right,target,min);
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
        System.out.print("Enter target : ");
        int target = scn.nextInt();
        System.out.println("Min absolute diff is : "+minDiff(root,target,Integer.MAX_VALUE));
    }
}