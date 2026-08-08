import java.util.*;

class Max_sum_after_k_negations {

    public static int largestSumAfterKNegations(int[] nums, int k) {
        
        Arrays.sort(nums);

        for(int i=0; i<nums.length && k > 0; i++){
            if(nums[i] < 0){
                nums[i] = -1 * nums[i];
                k--;
            }
            else if(nums[i] == 0){
                k = 0;
            }
            else{
                break;
            }
        }

        if(k > 0 && k % 2 == 1){
            Arrays.sort(nums);
        }

        int largestSum = 0;

        for(int num : nums){
            largestSum += num;
        }

        if(k % 2 == 1){
            largestSum += -2 * nums[0];
        }

        return largestSum;

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter elements in the array : ");

        for(int i=0; i<n; i++){
        nums[i] = scn.nextInt();
        }

        System.out.print("Enter k : ");
        int k = scn.nextInt();

        System.out.println("Maximum sum after " + k + " negations is : " + largestSumAfterKNegations(nums,k));

    }
}