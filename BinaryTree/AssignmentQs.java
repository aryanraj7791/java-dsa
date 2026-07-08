import java.util.*;

public class AssignmentQs{

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

        public void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
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

        public boolean isUnivalued(Node root){
            if(root == null){
                return true;
            }
            if(root.left != null && root.data != root.left.data){
                return false;
            }
            if(root.right != null && root.data != root.right.data){
                return false;
            }
            return isUnivalued(root.left) && isUnivalued(root.right);
        }

        public Node mirror(Node root){
            if(root == null){
                return null;
            }
            Node left = mirror(root.left);
            Node right = mirror(root.right);
            root.left = right;
            root.right = left;
            return root;
        }

        public Node deleteLeaf(Node root, int target){
            if(root == null){
                return null;
            }
            root.left = deleteLeaf(root.left,target);
            root.right = deleteLeaf(root.right,target);
            if(root.left == null && root.right == null && root.data == target){
                return null;
            }
            return root;
        }
        int currSum=0,maxSum=Integer.MIN_VALUE;
        public int maxPathSum(Node root){
            if(root == null){
                return 0;
            }
            //Post Order DFS
            int leftSum = maxPathSum(root.left);
            int rightSum = maxPathSum(root.right);
            int currPath = leftSum+rightSum+root.data;
            currSum = Math.max(Math.max(leftSum+root.data,rightSum+root.data),root.data);
            maxSum = Math.max(currSum,currPath);
            return Math.max(leftSum,rightSum)+root.data;
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
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        // System.out.print(bt.isUnivalued(root));
        // bt.levelOrder(bt.mirror(root));
        // System.out.print("Enter target : ");
        // int target = scn.nextInt();
        // bt.levelOrder(bt.deleteLeaf(root,target));
        System.out.print("Maximum path sum is : " + bt.maxPathSum(root));
    }
}