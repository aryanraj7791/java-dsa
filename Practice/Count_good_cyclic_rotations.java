import java.util.*;
import java.io.*;

class Count_good_cyclic_rotations {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int countGoodRotations(int[] nums) {

        int n = nums.length;

        int ans = 0;

        long totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        long currSum = 0;

        int half = n/2;

        for(int i=n-1; i>=n-half; i--){
            currSum += nums[i];
        }

        for(int i=0; i<n; i++){

            long rightScore = currSum;

            long leftScore = totalSum - currSum;

            if(leftScore > rightScore) ans++;

            currSum -= nums[(half + i) % n];

            currSum += nums[i];

        }

        return ans;
        
    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();
        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<nums.length; i++){
            nums[i] = nextInt();
        }

        System.out.println("Good cyclic counts is: " + countGoodRotations(nums));
    }

}