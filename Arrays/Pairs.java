import java.util.*;

public class Pairs{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        //Taking input in array
        System.out.print("Enter elements in array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        //Possible pairs
        int tp=0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.print("Total pairs are: " + tp);
    }
}