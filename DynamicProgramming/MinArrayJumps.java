import java.util.*;

public class MinArrayJumps {

    public static int minJumpsMemo(int[] arr, int i, int[] dp){
        //Basecase
        if(i == arr.length-1){
            return 0;
        }

        if(i >= arr.length){
            return Integer.MAX_VALUE;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int minJumps = Integer.MAX_VALUE;

        for(int j=1; j<=arr[i]; j++){
            int jumps = minJumpsMemo(arr,i+j,dp);
            if(jumps != Integer.MAX_VALUE){
                minJumps = Math.min(minJumps,1+jumps);
            }
        }

        return dp[i] = minJumps;
    }

    public static int minJumpsTab(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            for(int j=1; j<=arr[i] && i+j < arr.length; j++){
                int jumps = dp[i+j];
                if(jumps != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+jumps);
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println("Minimum jumps needed to reach destination is : "+minJumpsMemo(arr,0,dp));
        System.out.println("Minimum jumps needed to reach destination is : "+minJumpsTab(arr));
    }
}