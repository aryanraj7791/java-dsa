import java.util.*;

public class ReverseStringUsingStack{
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }
        str = "";
        while(!s.isEmpty()){
            str += s.pop();
        }
        return str;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scn.next();
        System.out.print("Reversed string is : "+reverseString(str));
    }
}