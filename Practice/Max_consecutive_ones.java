import java.util.*;
import java.io.*;

class Max_consecutive_ones {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int findMaxConsecutiveOnes(int[] nums){

        int maxConsecutive = Integer.MIN_VALUE;

        int count = 0;

        for(int num : nums){

            if(num == 1){

                count++;

            }
            else{

                maxConsecutive = Math.max(maxConsecutive, count);

                count = 0;

            }

        }

        maxConsecutive = Math.max(maxConsecutive, count);

        return maxConsecutive;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of binary array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the binary array: ");

        for(int i=0; i<n; i++){

            nums[i] = nextInt();

        }

        System.out.println("Max consecutive ones: " + findMaxConsecutiveOnes(nums));

    }

}