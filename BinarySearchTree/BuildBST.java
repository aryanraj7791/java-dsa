import java.util.*;

public class BuildBST{

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

    public static boolean searchKey(Node root, int key){ //O(H) where H-> Height of BS tree
        if(root == null){
            return false;
        }
        if(root.val == key) return true;
        else if(root.val < key){
            return searchKey(root.right,key);
        }else{
            return searchKey(root.left,key);
        }
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
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
        System.out.print("Enter key : ");
        int key = scn.nextInt();
        if(searchKey(root,key)) System.out.print("Key found!");
        else System.out.print("Key not found!");
    }
}