import java.util.*;

public class CountingSort{

    public static void countingSort(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        int brr[] = new int[max+1];
        for(int i=0; i<arr.length; i++){
           brr[arr[i]] = brr[arr[i]] + 1;
        }
        int j=0;
        for(int i=0; i<=max; i++){
            if(brr[i] == 0){
                continue;
            }
            while(brr[i]>0){
                arr[j] = i;
                j++;
                brr[i] = brr[i] - 1;
            }
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
        countingSort(arr);
        printArr(arr);
    }
}