import java.util.*;
import java.io.*;

public class Candy {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int minCandies(int[] ratings){

        int n = ratings.length;

        int[] left = new int[n];

        int[] right = new int[n];

        left[0] = 1;

        for(int i=1; i<n; i++){

            left[i] = ratings[i] > ratings[i-1] ? left[i-1] + 1 : 1;

        }

        right[n-1] = 1;

        for(int i=n-2; i>=0; i--){

            right[i] = ratings[i] > ratings[i+1] ? right[i+1] + 1 : 1;

        }

        int totalCandies = 0;

        for(int i=0; i<n; i++){

            totalCandies += Math.max(left[i], right[i]);

        }

        return totalCandies;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter number of children: ");
        int n = nextInt();

        int[] ratings = new int[n];

        System.out.println("Enter ratings of children: ");

        for(int i=0; i<n; i++){

            ratings[i] = nextInt();

        }

        System.out.println("Minimum candies to be distributed is: " + minCandies(ratings));

    }

}