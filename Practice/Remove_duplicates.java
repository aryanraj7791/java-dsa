import java.util.*;
import java.io.*;

class Remove_duplicates { 

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int removeDuplicates(int[] nums) { 
 
        int n = nums.length; 
 
        int idx = 1; 
         
        for(int i=1; i<nums.length; i++){ 
 
            if(nums[i] == nums[i-1]){ 
                 
                while(i<n && nums[i] == nums[i-1]){ 
 
                    i++; 
 
                } 
 
                if(i<n) nums[idx++] = nums[i]; 
 
            } 
            else{

                nums[idx++] = nums[i]; 
 
            } 
 
        } 
 
        return idx; 
 
    } 

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){

            nums[i] = nextInt();

        }

        int k = removeDuplicates(nums);

        System.out.println("Unique elements in the array are: " + k);

        System.out.println("Array after modifying first " + k + " unique elements: ");

        for(int i=0; i<n; i++){

            System.out.print(nums[i] + " ");

        }

    }

}