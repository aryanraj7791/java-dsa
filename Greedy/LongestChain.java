import java.util.*;

public class LongestChain{
    public static int longestChain(int [][]arr){
        Arrays.sort(arr,Comparator.comparingInt(o -> o[1]));
        int i=0,j=1;
        int maxLength=1;
        while(i < arr.length-1 && j < arr.length){
            if(arr[i][1] < arr[j][0]){
                maxLength++;
                i = j;
            }
            j++;
        }
        return maxLength;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of pairs : ");
        int n = scn.nextInt();
        int [][]arr = new int[n][2];
        for(int i=0; i<n; i++){
                System.out.print("Enter x"+i+" : ");
                arr[i][0] = scn.nextInt();
                System.out.print("Enter y"+i+" : ");
                arr[i][1] = scn.nextInt();
        }
        System.out.println("Maximum length of chain is : "+longestChain(arr));
    }
}