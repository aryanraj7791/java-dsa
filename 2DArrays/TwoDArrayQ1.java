import java.util.*;

public class TwoDArrayQ1{

    public static int countFrequency(int arr[][],int target){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == target){
                    count++;
                }
            }
        }
        return count;
    }

    public static void printArray(int arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = scn.nextInt();
        System.out.print("Enter number of columns: ");
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        System.out.print("Enter elements in the array: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.print("Enter target for frequency: ");
        int target = scn.nextInt();

        printArray(arr);
        int ans = countFrequency(arr,target);
        System.out.print("Number of " + target + " in given 2D Array is: " + ans);
    }
}