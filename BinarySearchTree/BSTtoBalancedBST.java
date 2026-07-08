import java.util.*;

public class BSTtoBalancedBST{

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

    public static void inOrder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        inOrder(root.left,inorder);
        inorder.add(root.val);
        inOrder(root.right,inorder);
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBalancedBST(ArrayList<Integer> inorder, int si, int ei){ //TC-O(n)
        if(si > ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBalancedBST(inorder,si,mid-1);
        root.right = createBalancedBST(inorder,mid+1,ei);
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
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(root,inorder);
        Node balancedRoot = createBalancedBST(inorder,0,inorder.size()-1);
        preOrder(balancedRoot);
    }
}