import java.util.*;

public class CountUniqueSubstrings{

    public static class Node{
        Node[] children = new Node[26];
        Boolean eow = false;
        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    private static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countUnique(String str){
        //Store all suffixes inside a list
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            list.add(str.substring(i));
        }
        //Build prefix tree from all suffixes
        for(int i=0; i<list.size(); i++){
            insert(list.get(i));
        }
        //Count all nodes of TRIE for unique substrings
        int substrings = countNodes(root);
        return substrings;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count=0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args){
        String str = "apple";
        System.out.println("Total unique substrings of "+str+" is : "+countUnique(str));
    }
}