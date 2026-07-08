import java.util.*;

public class MergeSort{

    public static void mergeSort(int arr[],int si, int ei){
        //Base case
        if(si >= ei){
            return;
        }
        
        //work
        int mid = si + (ei-si)/2;
        mergeSort(arr,si,mid); //left part array
        mergeSort(arr,mid+1,ei); //right part array
        merge(arr,si,mid,ei);
    }

    public static void merge(int []arr, int si, int mid, int ei){

        int []temp = new int[ei-si+1];
        int i = si; //iterator for left array
        int j = mid+1; //iterator for right array
        int k = 0; //iterator for temp array

        while(i<=mid && j<=ei){
            if(arr[i]>arr[j]){
                temp[k++] = arr[j++];
            }
            else{
                temp[k++] = arr[i++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(k=0,i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
    }

    public static void printArray(int []arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
    }
}