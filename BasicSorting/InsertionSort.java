import java.util.*;

public class InsertionSort{
    public static void insertionSort(int arr[]){

        //Insertion Sort
        for(int i=1; i<arr.length; i++){
          int curr = arr[i];
          int prev = i-1;
          //Finding the correct position for curr
          while(prev>=0 && arr[prev]>curr){
            arr[prev+1] = arr[prev];
            prev--;
          }
          //insertion of arr[curr] at its correct position in sorted array
          arr[prev+1] = curr;
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
        //Taking input from user
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        insertionSort(arr);
        printArr(arr);
    }
}