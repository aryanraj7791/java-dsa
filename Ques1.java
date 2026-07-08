import java.util.*;

public class Ques1 {

    public static int sumCheck(int[] arr, int k){
        int []remCount = new int[k];
        int ans = 0;
        for(int num : arr){
           int rem = num % k;
           int comp = (k - rem)%k;
           ans += remCount[comp];
           remCount[rem]++;
        }
        for(int num: remCount) System.out.print(num+" ");
        System.out.println();
        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter values in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter k : ");
        int k = scn.nextInt();

        System.out.print("Total ways is : "+sumCheck(arr, k));
    }
}