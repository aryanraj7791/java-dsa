import java.util.*;

class Solution {
    public static int singleNumber(int[] nums) {
        int ans = 0;

        for(int bit = 0; bit < 32; bit++){
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if((nums[i] & (1 << bit)) != 0) count++;
            }
            if(count % 3 == 1){
                ans += 1 << bit;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array nums : ");
        int n = scn.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            nums[i] = scn.nextInt();
        }
        System.out.println(singleNumber(nums));
    }
}