import java.util.*;

public class SelectionSort{

    public static void selectionSort(int arr[]){

        //selection sort
        boolean flag = true;
        for(int i=0; i<arr.length-1; i++){
            int idx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[idx]>arr[j]){
                    idx = j;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        selectionSort(arr);
        printArr(arr);
    }
}