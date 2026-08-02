import java.util.*;

class Count_subarrays_with_even_odd_ratio {
    public static int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int count = 0;

        for(int i=0; i<n; i++){
            int x = 0;
            int y = 0;

            for(int j=i; j<n; j++){
                if(nums[j] % 2 == 0) x++;
                else y++;
                if(y > 0 && (long)x * b <= (long)a * y) count++;
            }
        }

        return count;
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

        System.out.print("Enter a : ");
        int a = scn.nextInt();

        System.out.print("Enter b : ");
        int b = scn.nextInt();

        System.out.println("Number of subarrays with even-odd ratio : " + countRatioSubarrays(nums,a,b));

    }
}