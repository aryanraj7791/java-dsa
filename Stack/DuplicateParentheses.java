import java.util.*;

public class DuplicateParentheses{
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                int count=0;
                while(s.peek() != '('){
                    count++;
                    s.pop();
                }
                if(count == 0){
                    return false;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str1 = "((a+b))";
        String str2 = "(((a+b)+(a+b)))";
        System.out.print(isDuplicate(str2));
    }
}