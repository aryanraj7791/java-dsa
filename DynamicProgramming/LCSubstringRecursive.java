import java.util.*;

public class LCSubstringRecursive {

    static int res = 0;

    public static void lcs(String str1, String str2, int i, int j, int ans){

        res = Math.max(res,ans);
        
        //Basecase
        if(i == str1.length() || j == str2.length()){
            return;
        }

        //work
        if(str1.charAt(i) == str2.charAt(j)){
            lcs(str1,str2,i+1,j+1,ans+1);
        }
        else{
            lcs(str1,str2,i+1,j,0);
            lcs(str1,str2,i,j+1,0);
        }
    }

    public static void main(String[] args){
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";

        lcs(str1,str2,0,0,0);

        System.out.println("Length of longest common substring is : " + res);
    }
}