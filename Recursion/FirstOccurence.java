import java.util.*;

public class FirstOccurence{

    public static int firstOccurence(int arr[], int target, int i){
        if(i == arr.length){
            return -1; //Element is not present in the array
        }
        if(arr[i] == target){
            return i; //Element found, returning its index
        }
        return firstOccurence(arr,target,i+1); // Recursive Call
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
        int ans = firstOccurence(arr,target,0);
        if(ans>=0){
            System.out.print("Index of first occurence of " + target + " is : " + ans);
        }
        else{
            System.out.print("Element is not present in the array!");
        }
    }
}