import java.util.*;

public class ClimbingStairs{

    // Memoization O(n) | recursion O(2^n)
    public static int climbStairs(int n, int[] dp){
        if(n == 0) return 1;
        if(n == 1 || n == 2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp) + climbStairs(n-3, dp);
        return dp[n];
    }

    //Tabulation O(n)
    public static int climbStairsTabulation(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of stairs to climb : ");
        int n = scn.nextInt();
        if(n < 0){
            System.out.print("Total ways : " + 0);
            return;
        }
        int[] dp = new int[n+1];
        System.out.println("Total ways : "+climbStairs(n,dp));
    }
}