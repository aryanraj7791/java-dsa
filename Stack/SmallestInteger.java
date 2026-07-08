import java.util.*;

public class SmallestInteger{
    public static String smallestInt(String str, int k){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            while(!s.isEmpty() && (s.peek()-'0') > (ch-'0') && k > 0){
                s.pop();
                k--;
            }
            s.push(ch);
        }
        while(k > 0){
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            sb.deleteCharAt(i);
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter string of digits : ");
        String str = scn.next();
        System.out.print("Enter number of digits to be removed : ");
        int k = scn.nextInt();
        System.out.print("Smallest integer after removing " + k + " digits is : " + smallestInt(str,k));
    }
}