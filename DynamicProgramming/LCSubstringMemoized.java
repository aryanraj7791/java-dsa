import java.util.*;

public class LCSubstringMemoized {

    static int maxLength = 0;

    public static int lcsMemoized(String str1, String str2, int n, int m, int[][] dp){
        //Basecase
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = 1 + lcsMemoized(str1,str2,n-1,m-1,dp);
            maxLength = Math.max(maxLength, dp[n][m]);
        }
        else{
            dp[n][m] = 0;
            lcsMemoized(str1,str2,n-1,m,dp);
            lcsMemoized(str1,str2,n,m-1,dp);
        }

        return dp[n][m];
    }

    public static void main(String[] args){
        String str1 = "ABCDGHR";
        String str2 = "ACDGHRM";

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = -1;
            }
        }

        lcsMemoized(str1,str2,n,m,dp);

        System.out.println("Length of longest common substring is : " + maxLength);
    }
}