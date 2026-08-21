import java.util.*;
import java.io.*;

class Majority_element_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static List<Integer> majorityElement(int[] nums) {

        int threshold = nums.length/3;
        
        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        for(int num : nums){

            if(count1 > 0 && candidate1 == num){
                count1++;
            }
            else if(count2 > 0 && candidate2 == num){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }

        if(count1 > threshold) res.add(candidate1);
        if(count2 > threshold) res.add(candidate2);

        // Collections.sort(res);

        return res;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){
            nums[i] = nextInt();
        }

        List<Integer> res = majorityElement(nums);

        System.out.println("Elements occuring more than n/3 are: ");

        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i) + " ");
        }

        System.out.println();

    }

}