import java.util.*;
import java.io.*;

class Contiguous_Array {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int maxSubarrayLength(int[] nums) {
        
        int n = nums.length;

        int currSum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

            currSum += nums[i] == 0 ? -1 : 1;

            if(map.containsKey(currSum)){
                maxLength = Math.max(maxLength, i - map.get(currSum));
            }
            else{
                map.put(currSum, i);
            }

        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
        
    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.println("Enter size of binary array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter '0' or '1' in the array: ");

        for(int i=0; i<n; i++){

            nums[i] = nextInt();

        }

        System.out.println("Max length subarray having equal number of zeros and ones is: " + maxSubarrayLength(nums));

    }

}