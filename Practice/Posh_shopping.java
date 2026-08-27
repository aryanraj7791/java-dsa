import java.util.*;
import java.io.*;

class Posh_shopping {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int maxAmount(int[] costs){

        int n = costs.length;

        int[] suffix = new int[n];

        suffix[n-1] = -1;

        int max = costs[n-1];

        for(int i=n-2; i>=0; i--){

            if(costs[i] <= max){

                suffix[i] = max;

            }
            else{

                suffix[i] = -1;

                max = costs[i];

            }

        }

        int best = 0;

        for(int i=0; i<n; i++){

            best = Math.max(best,costs[i]);

            if(suffix[i] != -1){
                
                best = Math.max(best, costs[i]+suffix[i]);

            }

        }

        return best;

    }

    public static void main(String[] args) throws java.lang.Exception {

        int t = nextInt();

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){

            int N = nextInt();

            int[] costs = new int[N];

            for(int i=0; i<N; i++){

                costs[i] = nextInt();

            }

            sb.append(maxAmount(costs)).append('\n');

        }

        System.out.println("Outputs for each test case: ");

        System.out.print(sb);

    }

}