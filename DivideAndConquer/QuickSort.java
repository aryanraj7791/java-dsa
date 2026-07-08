import java.util.*;

public class QuickSort{

    public static void printArray(int []arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int []arr, int si, int ei){
        int idx = si-1;
        int pivot = arr[ei];
        for(int j=si; j<ei; j++){
            if(arr[j]<pivot){
                idx++;
                //swap
                int temp = arr[idx];
                arr[idx] = arr[j];
                arr[j] = temp;
            }
        }
        idx++;
        int temp = arr[idx];
        arr[idx] = arr[ei];
        arr[ei] = temp;
        return idx;
    }

    public static void quickSort(int []arr, int si, int ei){
        if(si >= ei){
            return;
        }
        //last element
        int pidx = partition(arr,si,ei);
        quickSort(arr,si,pidx-1);
        quickSort(arr,pidx+1,ei);
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
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}