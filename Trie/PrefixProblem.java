import java.util.*;

public class PrefixProblem{

    private static class Node{
        Node[] children = new Node[26];
        Boolean eow = false;
        int freq;
        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    private static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static Boolean searchWord(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    static ArrayList<String> list = new ArrayList<>();
    public static void findPrefix(Node root, StringBuilder ans){

        if(root == null) return;

        if(root.freq == 1){
            list.add(ans.toString());
            return;
        }

         
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                ans.append((char)(i+'a'));
                findPrefix(root.children[i],ans);
                ans.deleteCharAt(ans.length()-1); //Backtrack
            }
        }
    }


    public static void main(String[] args){
        String[] arr = {"zebra","dog","duck","dove"};
        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        }
        root.freq = -1;
        findPrefix(root,new StringBuilder(""));
        System.out.println(list);
    }
}