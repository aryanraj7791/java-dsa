import java.util.*;

public class BasicTrie{

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

    public static void main(String[] args){
        String[] words = {"the","a","there","their","any","thee"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
        System.out.println(searchWord("alt"));
    }
}
