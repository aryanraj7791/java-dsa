import java.util.*;
import java.io.*;

class Mindays_toscore_Npoints {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int minDays(int n){

        int[] dp = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int j=1; j<=n; j++){

            for(int k=1; k *(k+1)/2 <= j; k++){

                int T = k * (k+1) / 2;

                int rem = j - T;

                if(dp[rem] == Integer.MAX_VALUE) continue;

                int cost = dp[rem] + k + (rem > 0 ? 1 : 0);

                dp[j] = Math.min(dp[j], cost);
                
            }
            
        }

        return dp[n];

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter target score: ");
        int n = nextInt();

        System.out.println("Minimum number of days to score " + n + " points is: " + minDays(n));

    }

}