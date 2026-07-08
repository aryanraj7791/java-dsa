import java.util.*;

public class BubbleSort{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        //Taking input in the array
        System.out.print("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        //Modified Bubble sort algorithm
        for(int i=0; i<arr.length-1; i++){
            boolean flag = true;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag) break;
        }
        //printing sorted array
        System.out.print("Sorted array: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}