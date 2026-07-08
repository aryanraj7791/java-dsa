import java.util.*;

public class CountNodes{
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

    static class BinaryTree{
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

        public int countNodes(Node root){ //O(n)
            if(root == null){
                return 0;
            }
            int lstNode = countNodes(root.left);
            int rstNode = countNodes(root.right);
            return lstNode + rstNode + 1;
        }

        public int sumNodes(Node root){ //O(n)
            if(root == null){
                return 0;
            }
            int lstSum = sumNodes(root.left);
            int rstSum = sumNodes(root.right);
            return lstSum + rstSum + root.data;
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
        System.out.println("Total nodes in tree is : "+bt.countNodes(root));
        System.out.println("Sum of all nodes of tree is : "+bt.sumNodes(root));
    }
}