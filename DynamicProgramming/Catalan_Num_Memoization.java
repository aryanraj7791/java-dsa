import java.util.*;

public class Catalan_Num_Memoization{

    public static int catalanMem(int n, int[] dp){

        if(n == 0 || n == 1) return 1;

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catalanMem(i,dp) * catalanMem(n-i-1,dp);
        }

        return dp[n] = ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Catalan of " + n + " is : " + catalanMem(n,dp));
    }
}