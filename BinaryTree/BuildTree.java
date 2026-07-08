import java.util.*;

public class BuildTree{

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
        public static Node buildTree(int []nodes){ //O(n)
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void preOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public void postOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public void levelOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public void kthlevel(Node root, int level, int k){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data+" ");
                return;
            }
            kthlevel(root.left,level+1,k);
            kthlevel(root.right,level+1,k);
        }

        public int height(Node root){
            if(root == null){
                return 0;
            }
            int leftheight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftheight,rightHeight)+1;
        }

    }
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes in tree : ");
        int n = scn.nextInt();
        int nodes[] = new int[n];
        System.out.println("Enter nodes value : ");
        for(int i=0; i<nodes.length; i++){
            nodes[i] = scn.nextInt();
        }
        System.out.print("Enter level : ");
        int k = scn.nextInt();
        Node root = bt.buildTree(nodes); //root of the tree
        // bt.preOrder(root);
        // System.out.println();
        // bt.inOrder(root);
        // System.out.println();
        // bt.postOrder(root);
        // System.out.println();
        // bt.levelOrder(root);
        // System.out.println("Maximum height of tree is : "+bt.height(root));
        bt.kthlevel(root,1,k);
    }
}