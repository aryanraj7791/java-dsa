import java.util.*;

public class KthLargestOddNumber{
    public static int kthLargest(int n, int m, int k){
        int oddTrack=0;
        while(m >= n){
            if(m % 2 != 0){
                oddTrack++;
            }
            if(oddTrack == k) return m;
            m--;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter L : ");
        int n = scn.nextInt();
        System.out.print("Enter R(>=L) : ");
        int m = scn.nextInt();
        System.out.print("Enter k : ");
        int k = scn.nextInt();
        System.out.println("Kth largest odd number is : "+kthLargest(n,m,k));
    }
}