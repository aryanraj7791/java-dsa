import java.util.*;
import java.io.*;

class Rotate_array_k_times {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st ==  null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());
    }

    public static void rotate(int[] nums, int k){

        int n = nums.length;

        k = k % n;

        int i = 0, j = n-k-1;

        while(i < j){

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;

        }

        i = n-k;
        j = n-1;

        while(i < j){

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;

        }

        i = 0;
        j = n-1;

        while(i < j){

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;

        }

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){
            nums[i] = nextInt();
        }

        System.out.print("Enter number of rotations: ");
        int k = nextInt();

        rotate(nums,k);

        System.out.println("Array after rotated " + k + " times: ");

        for(int num: nums){
            System.out.print(num + " ");
        }

    }

}