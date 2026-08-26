import java.util.*;
import java.io.*;

public class Gas_station {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int func(int[] gas, int[] cost){

        int n = gas.length;

        for(int i=0; i<n; i++){

            int currGas = gas[i];

            if(currGas >= cost[i]){

                int idx = i;

                int count = 0;

                while(currGas >= cost[idx]){

                    count++;

                    if(count == n) return i;

                    currGas -= cost[idx];

                    currGas += gas[++idx % n];

                    idx %= n;

                }

                if(idx < i){
                    return -1;
                }

                i = idx - 1;

            }

        }

        return -1;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter number of gas stations: ");
        int n = nextInt();
        int[] gas = new int[n];

        for(int i=0; i<n; i++){

            System.out.print("Enter gas at station " + (i) + " : ");
            gas[i] = nextInt();

        }

        int[] cost = new int[n];
        System.out.println("Enter cost to go from ith to (i+1)th station: ");

        for(int i=0; i<n; i++){
            
            System.out.print("Enter cost to go from station" + i + " to station" + ((i+1)%n) + " : ");
            cost[i] = nextInt();

        }

        System.out.println("Starting index to complete circular circuit is: " + func(gas,cost));

    }

}