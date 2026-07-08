import java.util.*;

public class LCSubstringTabulation {

    static int maxLength = 0;

    public static void lcsTabulation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        print(dp);        
    }

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        String str1 = "ABCDGHR";
        String str2 = "ACDGHRM";

        lcsTabulation(str1,str2);

        System.out.println("Length of longest common substring is : "+ maxLength);
    }
}