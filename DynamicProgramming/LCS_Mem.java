import java.util.*;

public class LCS_Mem{

    public static void print(String[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(dp[i][j] == ""){
                    System.out.print("- ");
                }
                else System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String lcs(String str1, String str2, int n, int m, String[][] dp){
        if(n == 0 || m == 0){
            dp[n][m] = "";
            return dp[n][m];
        }

        if(!dp[n][m].equals("")){
            return dp[n][m];
        }
        else{
            if(str1.charAt(n-1) == str2.charAt(m-1)){
                dp[n][m] = lcs(str1, str2, n-1, m-1, dp) + str1.charAt(n-1);
            }
            else{
                String ans1 = lcs(str1, str2, n-1, m, dp);
                String ans2 = lcs(str1, str2, n, m-1, dp);
                dp[n][m] = ans1.length() > ans2.length() ? ans1 : ans2;
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args){
        String str1 = "abdeg";
        String str2 = "abdg";

        String[][] dp = new String[str1.length()+1][str2.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = "";
            }
        }

        String res = lcs(str1,str2,str1.length(),str2.length(),dp);

        System.out.println("Longest common subsequence is : "+res);
        System.out.println("Length of longest common subsequence is : "+res.length());
        print(dp);
    }
}