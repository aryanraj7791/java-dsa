import java.util.*;

public class CheckForSortedArray{

    public static boolean checkSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return checkSorted(arr, i+1);
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
        if(checkSorted(arr,0)){
            System.out.print("Array is sorted");
        }
        else System.out.print("Array is not sorted");
    }
}