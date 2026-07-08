import java.util.*;

public class LastOccurence{

    public static int lastOccurence(int arr[], int target, int i){
        if(i<0){
            return -1; //Element is not present in the array
        }
        if(arr[i] == target){
            return i; //Element found, returning its index
        }
        return lastOccurence(arr,target,i-1); // Recursive Call
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter target: ");
        int target = scn.nextInt();
        int ans = lastOccurence(arr,target,arr.length-1);
        if(ans>=0){
            System.out.print("Index of last occurence of " + target + " is : " + ans);
        }
        else{
            System.out.print("Element is not present in the array!");
        }
    }
}