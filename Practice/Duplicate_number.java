import java.util.*;
import java.io.*;

class Duplicate_number {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int duplicateNumber(int[] nums){

        int slow = 0;
        int fast = 0;

        do{

            slow = nums[slow];

            fast = nums[nums[fast]];

        }
        while(slow != fast);

        slow = 0;

        while(slow != fast){

            slow = nums[slow];

            fast = nums[fast];

        }

        return slow;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array(between 1 to size of array-1 both inclusive with exactly one duplicate number): ");

        for(int i=0; i<n; i++){
            nums[i] = nextInt();
        }

        System.out.println("Duplicate number is: " + duplicateNumber(nums));

    }

}