import java.util.*;

public class StringComparisons{

    public static String largestString(String[] arr){
        String str = arr[0];
        for(int i=1; i<arr.length; i++){
            if(str.compareTo(arr[i])<0){
                str = arr[i];
            }
        }
        return str;
    }

    public static void printArr(String[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = scn.nextInt();
        scn.nextLine();
        String[] arr = new String[n];
        System.out.print("Enter strings: ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextLine();
        }
        printArr(arr);
        System.out.print("\nLargest string is: " + largestString(arr));
    }
}