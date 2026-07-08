import java.util.*;

public class StringSubsets{

    public static void printSubsets(String str, int idx, String ans){
        if(idx == str.length()){
            if(ans.length() == 0) System.out.println("null");
            else System.out.println(ans);
            return;
        }
        //Yes choice
        printSubsets(str, idx+1, ans+str.charAt(idx));
        // No choice
        printSubsets(str,idx+1,ans);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scn.next();
        printSubsets(str,0,"");
    }
}