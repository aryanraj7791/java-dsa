import java.util.*;

public class ValidateBST3{

    public static class Info{
        boolean isValid;
        int min;
        int max;
        Info(boolean isValid, int min, int max){
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }

    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildBT(int []nodes){
        idx++;
        if(nodes[idx] == -1) return null;
        Node root = new Node(nodes[idx]);
        root.left = buildBT(nodes);
        root.right = buildBT(nodes);
        return root;
    }
    
    static boolean flag = true;
    public static Info isValidBST(Node root){
        if(root == null){
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo = isValidBST(root.left);
        Info rightInfo = isValidBST(root.right);
        if(leftInfo.isValid == false || rightInfo.isValid == false || root.val <= leftInfo.max || root.val >= rightInfo.min){
            flag = false;
            return new Info(false,Math.min(Math.min(root.val,leftInfo.min),rightInfo.min),Math.max(Math.max(root.val,leftInfo.max),rightInfo.max));
        }
        return new Info(true,Math.min(Math.min(root.val,leftInfo.min),rightInfo.min),Math.max(Math.max(root.val,leftInfo.max),rightInfo.max));
    }

    public static void main(String[] args){
        flag = true;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes in Binary tree : ");
        int n = scn.nextInt();
        int []nodes = new int[n];
        System.out.println("Enter preorder sequence : ");
        for(int i=0; i<n; i++){
            nodes[i] = scn.nextInt();
        }
        Node root = buildBT(nodes);
        isValidBST(root);
        if(flag){
            System.out.println("Given binary tree is a valid BST");
        }else{
            System.out.println("Given binary tree is not a valid BST");
        }
    }
}