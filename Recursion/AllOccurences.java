import java.util.*;

public class AllOccurences{

    public static void printAllOccurences(int arr[], int target, int i){
        if(i == arr.length){
            return;
        }
        if(arr[i] == target){
            System.out.print(i + " ");
        }
        printAllOccurences(arr,target,i+1);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter target: ");
        int target = scn.nextInt();
        printAllOccurences(arr,target,0);
    }
}