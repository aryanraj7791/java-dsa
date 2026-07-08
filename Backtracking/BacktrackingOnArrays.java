import java.util.*;

public class BacktrackingOnArrays{

    public static void printArray(int []arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void storeValues(int []arr, int idx){
        if(idx == arr.length){
            printArray(arr); //Array just before hitting base case
            return;
        }
        arr[idx] = idx+1;
        storeValues(arr,idx+1);
        arr[idx] = arr[idx] - 2; //Backtracking step
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int []arr = new int[n];
        storeValues(arr,0);
        printArray(arr); //Final array
    }
}