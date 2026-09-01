import java.util.*;
import java.io.*;

class Contains_duplicates {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){

            if(set.contains(num)) return true;

            set.add(num);

        }

        return false;        

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.println("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){

            nums[i] = nextInt();

        }

        System.out.println(containsDuplicate(nums));

    }

}