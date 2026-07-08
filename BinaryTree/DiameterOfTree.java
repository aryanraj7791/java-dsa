import java.util.*;

public class DiameterOfTree{

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        int diameter;
        int height;
        Info(int d, int h){
            diameter=d;
            height=h;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int []nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public int height(Node root){ //O(n)
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        public int diameterTree(Node root){ //O(n^2)
            if(root == null){ 
                return 0;
            }
            int lstDiameter = diameterTree(root.left);
            int rstDiameter = diameterTree(root.right);
            int rootDiameter = height(root.left) + height(root.right)+1;
            return Math.max(Math.max(lstDiameter,rstDiameter),rootDiameter);
        }

        public Info diameterTreeOptimised(Node root){ //O(n)
            if(root == null){
                return new Info(0,0);
            }
            Info left = diameterTreeOptimised(root.left);
            Info right = diameterTreeOptimised(root.right);
            int ld = left.diameter;
            int rd = right.diameter;
            int sd = left.height + right.height + 1;
            int dia = Math.max(Math.max(ld,rd),sd);
            int ht = Math.max(left.height,right.height)+1;
            return new Info(dia,ht);
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
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        Info info = bt.diameterTreeOptimised(root);
        System.out.println("Diameter is : " + info.diameter);
        System.out.println("Height is : " + info.height);
    }
}