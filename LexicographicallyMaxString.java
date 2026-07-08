import java.util.*;

public class LexicographicallyMaxString{

    public static String getString(String str){
        StringBuilder sb = new StringBuilder("");
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];
        for(char ch : str.toCharArray()){
            freq[ch-'a']++;
        }
        Stack<Character> s = new Stack<>();
        for(char ch: str.toCharArray()){
            freq[ch-'a']--;
            while(!s.isEmpty() && s.peek()<ch && freq[s.peek()-'a']>0){
                inStack[s.pop()-'a'] = false;
            }
            if(!inStack[ch-'a']){
                s.push(ch);
                inStack[ch-'a'] = true;
            }
        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scn.nextLine();
        System.out.println("Lexicographically maximum string is : "+getString(str));
    }
}