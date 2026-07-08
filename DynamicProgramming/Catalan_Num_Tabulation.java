import java.util.*;

public class Catalan_Num_Tabulation{

    public static int catalanTab(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<dp.length; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scn.nextInt();
        System.out.println("Catalan of "+ n + " is : " + catalanTab(n));
    }
}