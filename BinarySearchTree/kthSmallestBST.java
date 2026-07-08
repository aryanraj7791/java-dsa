import java.util.*;

public class kthSmallestBST{

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

    static int ans=0;
    static int res=0;
    public static void kthSmallest(Node root, int k){
        if(root == null){
            return;
        }
        kthSmallest(root.left,k);
        ans++;
        if(ans == k){
            res = root.val;
            return;
        }
        kthSmallest(root.right,k);
    }

    public static void main(String[] args){
        ans=0;
        res=0;
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
        System.out.print("Enter k : ");
        int k = scn.nextInt();
        kthSmallest(root,k);
        System.out.println("Kth smallest is : "+res);
    }
}