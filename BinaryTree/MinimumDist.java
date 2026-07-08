import java.util.*;

public class MinimumDist{

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
     }

        public static class BinaryTree{
            static int idx = -1;
            public Node buildTree(int []nodes){
                idx++;
                if(nodes[idx] == -1){
                    return null;
                }
                Node newNode = new Node(nodes[idx]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);
                return newNode;
            }

         public Node lca(Node root, int n1, int n2){

            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }

            Node leftAns = lca(root.left,n1,n2);
            Node rightAns = lca(root.right,n1,n2);

            if(leftAns == null){
                return rightAns;
            }
            if(rightAns == null){
                return leftAns;
            }

            return root;
         }

         public int lcaNode(Node lCA, int n){
            if(lCA == null){
                return -1;
            }
            if(lCA.data == n){
                return 0;
            }
            int leftAns = lcaNode(lCA.left,n);
            int rightAns = lcaNode(lCA.right,n);
            if(leftAns == -1 && rightAns == -1){
                return -1;
            }
            if(leftAns > -1){
                return leftAns+1;
            }
            return rightAns+1;
         }

         public int minDistance(Node root, int n1, int n2){
            Node lCA = lca(root,n1,n2);
            int d1 = lcaNode(lCA,n1);
            int d2 = lcaNode(lCA,n2);
            return d1+d2;
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = scn.nextInt();
        int []nodes = new int[n];
        System.out.println("Enter value of nodes : ");
        for(int i=0; i<nodes.length; i++){
            nodes[i] = scn.nextInt();
        }
        System.out.print("Enter n1 : ");
        int n1 = scn.nextInt();
        System.out.print("Enter n2 : ");
        int n2 = scn.nextInt();
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.print("Minimum distance between nodes "+n1+" and "+n2+" is : "+bt.minDistance(root,n1,n2));
    }
}