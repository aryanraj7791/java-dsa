import java.util.*;

class Solution {
    public static int[] singleNumber_3(int[] nums) {
        int x = 0;

        for(int num : nums){
            x = x ^ num;
        }

        int y = 1;

        while((x & y) == 0){
            y = y << 1;
        }

        int setBucket = 0;
        int unsetBucket = 0;

        for(int num : nums){
            if((num & y) == 0) unsetBucket = unsetBucket ^ num;
            else setBucket = setBucket ^ num;
        }

        return new int[]{setBucket,unsetBucket};
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
        int[] res = singleNumber_3(nums);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
