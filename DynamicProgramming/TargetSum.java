import java.util.*;

public class TargetSum{

    public static void print(boolean[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //TC --> O(n * target)
    public static boolean targetSumSubset(int[] nums, int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = nums[i-1];
                //include
                if(v <= j && dp[i-1][j-v]){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j]){
                    dp[i][j] = true;;
                }
            }
        }
        print(dp);
        return dp[n][target];
    }

    public static void main(String[] args){
        int[] nums = {4,2,7,1,3};
        int target = 10;
        System.out.println(targetSumSubset(nums,target));
    }
}