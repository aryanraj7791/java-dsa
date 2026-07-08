import java.util.*;

public class Merge2BST{

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

    public static void inOrder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node merge2BST(ArrayList<Integer> mergedSeq, int si, int ei){ //Tc-> O(n+m)
        if(si > ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(mergedSeq.get(mid));
        root.left = merge2BST(mergedSeq,si,mid-1);
        root.right = merge2BST(mergedSeq,mid+1,ei);
        return root;
    }

    public static void mergeSeq(ArrayList<Integer> mergedSeq, ArrayList<Integer> list1, ArrayList<Integer> list2){
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) > list2.get(j)){
                mergedSeq.add(list2.get(j));
                j++;
            }else{
                mergedSeq.add(list1.get(i));
                i++;
            }
        }
        while(i<list1.size()){
            mergedSeq.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            mergedSeq.add(list2.get(j));
            j++;
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes in BST1 : ");
        int n1 = scn.nextInt();
        int []bst1 = new int[n1];
        System.out.println("Enter values in BST1 : ");
        for(int i=0; i<n1; i++){
            bst1[i] = scn.nextInt();
        }
        System.out.print("Enter number of nodes in BST2 : ");
        int n2 = scn.nextInt();
        int []bst2 = new int[n2];
        System.out.println("Enter values in BST2 : ");
        for(int i=0; i<n2; i++){
            bst2[i] = scn.nextInt();
        }
        Node root1 = null;
        for(int i=0; i<n1; i++){
            root1 = buildBST(root1,bst1[i]);
        }
        Node root2 = null;
        for(int i=0; i<n2; i++){
            root2 = buildBST(root2,bst2[i]);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> mergedSeq = new ArrayList<>();
        inOrder(root1,list1);
        inOrder(root2,list2);
        mergeSeq(mergedSeq,list1,list2);
        Node mergedBST = merge2BST(mergedSeq,0,mergedSeq.size()-1);
        preOrder(mergedBST);
    }
}