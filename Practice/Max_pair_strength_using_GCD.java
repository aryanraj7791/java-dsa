import java.util.*;

class Max_pair_strength_using_GCD {
    public static long maxPairStrength(int[] nums) {
        int n = nums.length;
        long maxStrength = Long.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                long a = nums[i];
                long b = nums[j];
                long g = gcd(a,b);
                long strength = (a*b) / (g*g);
                maxStrength = Math.max(maxStrength,strength);
            }
        }

        return maxStrength;
    }

    public static long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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

        System.out.println("Max pair strength using GCD is : " + maxPairStrength(nums));

    }
}