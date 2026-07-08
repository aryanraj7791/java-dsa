import java.util.*;

public class LowestCommonAncestor{

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
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }
            boolean leftAns = getPath(root.left,n,path);
            boolean rightAns = getPath(root.right,n,path);
            if(leftAns || rightAns){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }

        public Node lowestCA(Node root, int n1, int n2){ //Path tracking: TC-> O(n), SC-> O(n)
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i=0;
            while(i<path1.size() && i<path2.size()){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
                i++;
            }
            return path1.get(i-1);
        }

        public Node lca(Node root, int n1, int n2){ //Recursion: TC-> O(n), SC-> O(n)--Due to recursion call stack
            if(root == null){
                return null;
            }
            if(root.data == n1 || root.data == n2){
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
        System.out.print("Enter n1 : ");
        int n1 = scn.nextInt();
        System.out.print("Enter n2 : ");
        int n2 = scn.nextInt();
        System.out.print("Lowest common ancestor is : " + bt.lca(root,n1,n2).data);
    }
}