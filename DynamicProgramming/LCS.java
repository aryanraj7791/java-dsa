import java.util.*;

public class LCS{

    public static String lcs(String str1, String str2, int n, int m){
        //Base case
        if(n == 0 || m == 0){
            return "";
        }
        //recursion
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1,str2,n-1,m-1) + str1.charAt(n-1);
        }
        else{
            String ans1 = lcs(str1,str2,n,m-1);
            String ans2 = lcs(str1,str2,n-1,m);
            return ans1.length() > ans2.length() ? ans1 : ans2;
        }
    }

    public static void main(String[] args){
        String str1 = "abcdge";
        String str2 = "abedg";

        String res = lcs(str1, str2, str1.length(), str2.length());
        System.out.println("Longest common subsequence is : "+res);
        System.out.println("Longest common subsequence length is : "+res.length());
    }
}