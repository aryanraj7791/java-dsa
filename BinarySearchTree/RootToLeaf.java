import java.util.*;

public class RootToLeaf{
    
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

    public static void rootLeaf(Node root, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res){
        if(root == null){
            return;
        }
        ans.add(root.val);
        rootLeaf(root.left,ans,res);
        rootLeaf(root.right,ans,res);
        if(root.left == null && root.right == null) res.add(new ArrayList<>(ans));
        ans.remove(ans.size()-1);
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
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        rootLeaf(root,ans,res);
        System.out.print(res);
    }
}