import java.util.*;

public class RemoveDuplicates{

    public static String removeDuplicates(String str, boolean bool[], StringBuilder sb, int i){
        if(i == str.length()){
            return sb.toString();
        }
        if(bool[str.charAt(i)-'a'] == false){
            sb.append(str.charAt(i));
            bool[str.charAt(i)-'a'] = true;
        }
       return removeDuplicates(str,bool,sb,i+1);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string(comprising only lowercase alphabets): ");
        String str = scn.next();
        scn.close();
        System.out.print("After removing duplicates: " + removeDuplicates(str,new boolean[26],new StringBuilder(""),0));
    }
}