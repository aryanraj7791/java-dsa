import java.util.*;

public class CountDistinct{

    public static int countDistinct(int []arr){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        return set.size();
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("Distinct element in the array is : "+countDistinct(arr));
    }
}