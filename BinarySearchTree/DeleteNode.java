import java.util.*;

public class DeleteNode{

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

    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            return null;
        }
        if(root.val < val){
            root.right = deleteNode(root.right,val);
        }
        else if(root.val > val){
            root.left = deleteNode(root.left,val);
        }
        else{
            //Case1-Leaf Node
            if(root.left == null && root.right == null){
                return null;
            }
            //Case2-One child Node
            if(root.left == null || root.right == null){
                if(root.left == null){
                    return root.right;
                }else{
                    return root.left;
                }
            }
            //Case3-Two children Node
            Node succ = inOrderSuccessor(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right,succ.val);
        }
        return root;
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
        System.out.print("Enter node value to be deleted : ");
        int m = scn.nextInt();
        inOrder(root);
        root = deleteNode(root,m);
        System.out.println();
        inOrder(root);
    }
}