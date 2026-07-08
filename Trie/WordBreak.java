import java.util.*;

public class WordBreak{

    public static class Node{

        Node[] children = new Node[26];
        Boolean eow = false; //End Of Word
        Node() {
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

        private static Node root = new Node(); //Root of a Trie

        public static void insert(String word){ //TC-->O(L) where L is the length of the longest word
            Node curr = root;
            for(int level=0; level<word.length(); level++){
                int idx = word.charAt(level)-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
        }

        public static Boolean searchWord(String word){ //TC-->O(L)
            Node curr = root;
            for(int level=0; level<word.length(); level++){
                int idx = word.charAt(level)-'a';
                if(curr.children[idx] == null){
                    return false;
                }
                curr = curr.children[idx];
            }
           return curr.eow;
        }

        public static Boolean wordBreak(String key){ //TC-->O(L)
            if(key.length() == 0) return true;
            for(int i=1; i<=key.length(); i++){
                if(searchWord(key.substring(0,i)) && wordBreak(key.substring(i))){
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args){
        String[] arr = {"i","like","sam","samsung","mobile","ice"};
        String key = "ilikesamsung";
        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        }
        System.out.println(wordBreak(key));
    }
}
