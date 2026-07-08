import java.util.*;

public class TrappingRainwater{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of bars: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter height of bars: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        //Auxiliary arrays
        int leftMostMax[] = new int[arr.length];
        int rightMostMax[] = new int[arr.length];
        leftMostMax[0] = arr[0];
        rightMostMax[arr.length-1] = arr[arr.length-1];
        //calculating leftMostMaximum Array
        for(int i=1; i<arr.length; i++){
            leftMostMax[i] = Math.max(leftMostMax[i-1],arr[i]);
        }
        //calculating rightMostMaximum Array
        for(int i=arr.length-2; i>=0; i--){
            rightMostMax[i] = Math.max(rightMostMax[i+1],arr[i]);
        }
        //Calculating Total water trapped between bars
        int totalTrappedWater = 0;
        for(int i=0; i<arr.length; i++){
            totalTrappedWater += Math.min(leftMostMax[i],rightMostMax[i]) - arr[i];
        }
        System.out.print("Total water trapped between bars is: " + totalTrappedWater);
    }
}