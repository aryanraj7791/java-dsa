import java.util.*;

public class FirstNonRepeatingLetter{
    public static void firstNonRepeating(String str, int []freq){
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i); //get ith character in ch
            q.add(ch); // Add ch to queue
            freq[ch-'a'] = freq[ch-'a'] + 1; //Increase freq of ch in freq array at its index
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove(); //remove repeating characters with frequency > 1
            }
            if(q.isEmpty()){
                System.out.println(-1); //all characters are repeating
            }else{
                System.out.println(q.peek()); //first non-repeating character
            }
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scn.next();
        int []freq = new int[26]; //'a'-'z'
        firstNonRepeating(str,freq);
    }
}