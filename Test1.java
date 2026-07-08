import java.util.*;

public class Test1{

    public static String parenthesis(String str){
        Stack s = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            Char ch = str.charAt(i);
            if(ch == '('){
                s.push(ch);
            }else{
                if(s.isEmpty()) {
                    while(!s.isEmpty()){
                        sb.append(s.pop());
                    }
                }
                else if(ch == ')') s.pop();

            }
        }

        if(s.isEmpty()){
            System.out.print("String is balanced")
        }
        return sb.toString();
    }

    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter string :");
        String str = scn.next();
        String ans  = parenthesis(str);
    }
}