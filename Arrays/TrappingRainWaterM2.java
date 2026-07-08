import java.util.*;

public class TrappingRainwaterM2{

    public static int trappingRainwaterM2(int arr[]){
        int low = 1;
        int high = arr.length-2;
        int lmax = arr[0];
        int rmax = arr[arr.length-1];
        int trappedWater = 0;
        while(low<=high){
            lmax = Math.max(arr[low],lmax);
            rmax = Math.max(arr[high],rmax);
            if(lmax<rmax){
                trappedWater += (lmax-arr[low]);
                low++;
            }
            else{
                trappedWater += (rmax-arr[high]);
                high--;
            }
        }
        return trappedWater;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of bars: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter height of bars: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Total rainwater trapped by bars is: " + trappingRainwaterM2(arr));
    }
}