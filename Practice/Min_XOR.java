import java.util.*;

class min_XOR {

    public static int minXor(int[] arr) {
        // code here
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        for(int i=0; i<n-1; i++){
            ans = Math.min(ans, arr[i] ^ arr[i+1]);
        }
        
        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements in the array : ");

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        System.out.println("Minimum XOR of any two different indexed element in arr is : " + minXor(arr));
    }
}