import java.util.*;

public class SubArrays{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        //Taking input in array
        System.out.print("Enter elements in array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println();
        int prefix[] = new int[n];
        int prefixSum=0;
        //Calculate prefix array
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        //Subarrays
        int tsa=0,sum=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                // for(int k=i; k<=j; k++){
                //     sum += arr[k];
                //     System.out.print(arr[k] + " ");
                // }
                tsa++;
                if(sum>max){
                    max=sum;
                }
                if(sum<min){
                    min=sum;
                }
                // System.out.println();
            }
            // System.out.println();
        }
        System.out.println("Total sub-arrays are: " + tsa);
        System.out.println("Max subArray sum is: " + max);
        System.out.println("Min subArray sum is: " + min);
    }
}