import java.util.*;

public class LIS {

    public static int lcs(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static int lis(int[] arr1){
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr1){
            set.add(num);
        }
        int[] arr2 = new int[set.size()];
        int idx=0;
        for(int num: set){
            arr2[idx++] = num;
        }
        Arrays.sort(arr2);
        return lcs(arr1,arr2);
    }

    public static void main(String[] args){
        int[] arr = {50,3,10,7,40,80,45,67,54,89};
        System.out.println("Length of longest increasing subsequence is : " + lis(arr));
    }
}