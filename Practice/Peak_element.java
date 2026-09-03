import java.util.*;
import java.io.*;

class Peak_element {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int peakElement(int[] nums){

        int n = nums.length;

        int low = 0;
        int high = n-1;

        while(low < high){

            int mid = low + (high - low) / 2;

            if(nums[mid] < nums[mid+1]){
                
                low = mid + 1;

            }
            else if(nums[mid] > nums[mid+1]){

                high = mid;

            }

        }

        return low;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){
            nums[i] = nextInt();
        }

        System.out.println("Index of peak element is: " + peakElement(nums));

    }

}