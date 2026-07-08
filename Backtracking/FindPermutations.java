import java.util.*;

public class FindPermutations{

    public static void findPermutations(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            findPermutations(newStr,ans+curr);
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scn.next();
        findPermutations(str,"");
    }
}