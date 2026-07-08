import java.util.*;

public class MinimumPartitioning {

    public static int minDiff(int[] wt, int[] val, int W){
        int n = wt.length;
        int [][] dp = new int[n+1][W+1];
        
        //Initialise the dp table
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        //Fill the dp table in bottom-up fashion
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int w = wt[i-1];
                int v = val[i-1];
                if(w <= j){
                    //Valid case
                    int incProfit = v + dp[i-1][j-w]; //Include profit
                    int excProfit = dp[i-1][j]; //Exclude profit
                    dp[i][j] = Math.max(incProfit,excProfit); //Take the maximum profit 
                }
                else{
                    //Invalid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        int W = sum/2;
        int sum1 = minDiff(arr,arr,W);
        int sum2 = sum-sum1;
        int ans = Math.abs(sum1-sum2);
        System.out.println("Minimum Subset Sum Difference is : " + ans);
    }
}