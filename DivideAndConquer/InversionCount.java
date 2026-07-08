import java.util.*;

public class InversionCount{
    public static int countInversion(int []arr, int si, int ei){
        if(si >= ei){
            return 0;
        }
        int mid = si + (ei-si)/2;
        return countInversion(arr,si,mid) + countInversion(arr,mid+1,ei) + crossInversion(arr,si,mid,ei);
    }

    public static int crossInversion(int []arr, int si, int mid, int ei){
        int i = si;
        int j = mid+1;
        int []temp = new int[ei-si+1];
        int k=0,ans=0;
        while(i<=mid && j<=ei){
            if(arr[i]>arr[j]){
                temp[k] = arr[j];
                j++;
                ans += mid-i+1;
            }
            else{
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for(i=si,k=0; k<temp.length; i++,k++){
            arr[i] = temp[k];
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int []arr = new int[n];
        System.out.println("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Number of inversion count in the given array is : " + countInversion(arr,0,arr.length-1));
    }
}