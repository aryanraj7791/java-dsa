import java.util.*;

public class TopViewTree{

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
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

        public static class Info{
            int hd;
            Node node;
            Info(int hd, Node node){
                this.hd = hd;
                this.node = node;
            }
        }

        public void topView(Node root){
            //Level Order Traversal
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer,Node> map = new HashMap<>();
            q.add(new Info(0,root));
            q.add(null); //Tracks end of each level
            int min=0;
            int max=0;
            while(!q.isEmpty()){
                Info currNodeInfo = q.remove();
                if(currNodeInfo == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(currNodeInfo.hd)){
                        map.put(currNodeInfo.hd,currNodeInfo.node); //first time my hd is occuring
                    }
                    if(currNodeInfo.node.left != null){
                        q.add(new Info(currNodeInfo.hd-1,currNodeInfo.node.left));
                        min = Math.min(min,currNodeInfo.hd-1);
                    }
                    if(currNodeInfo.node.right != null){
                        q.add(new Info(currNodeInfo.hd+1,currNodeInfo.node.right));
                        max = Math.max(max,currNodeInfo.hd+1);
                    }
                }
            }
            System.out.print("Top view of tree is : ");
            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = scn.nextInt();
        int nodes[] = new int[n];
        System.out.println("Enter value of nodes : ");
        for(int i=0; i<nodes.length; i++){
            nodes[i] = scn.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        bt.topView(root);
    }
}