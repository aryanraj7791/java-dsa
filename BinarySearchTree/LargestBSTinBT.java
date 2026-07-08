import java.util.*;

public class LargestBSTinBT{

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

    public static class Info{
        boolean isValid;
        int size;
        int min;
        int max;
        public Info(boolean isValid, int size, int min, int max){
            this.isValid = isValid;
            this.size = size;
            this.min = min;
            this.max = max;
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

    static int maxSize = 0;
    public static Info maxLengthBST(Node root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
       Info left =  maxLengthBST(root.left);
       Info right = maxLengthBST(root.right);
       if(left.isValid == true && right.isValid == true && root.val > left.max && root.val < right.min){
        Info rootInfo =  new Info(true,left.size+right.size+1,Math.min(root.val,Math.min(left.min,right.min)),Math.max(root.val,Math.max(left.max,right.max)));
        maxSize = Math.max(maxSize,rootInfo.size);
        return rootInfo;
       }
        return new Info(false,left.size+right.size+1,Math.min(root.val,Math.min(left.min,right.min)),Math.max(root.val,Math.max(left.max,right.max)));
    }

    public static void main(String[] args){
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        maxLengthBST(root);
        System.out.println("Max size BST is : "+maxSize);
    }
}