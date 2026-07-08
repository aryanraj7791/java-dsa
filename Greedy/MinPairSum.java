import java.util.*;

public class MinPairSum{
    public static int MinPairSum(int []a, int []b){
        Arrays.sort(a);
        Arrays.sort(b);
        int ans = 0;
        int i=0,j=0;
        while(j < a.length){
            if(a[j] <= b[i]){
                ans += b[i]-a[j];
                i = j;
                j++;
            }else{
                if(i+1 == b.length){
                    ans += a[j]-b[i];
                    i = j;
                    j++;
                }
                else if(a[j] < b[i+1]){
                    ans += Math.min(a[j]-b[i],b[i+1]-a[j]);
                    i = j;
                    j++;
                }
                else if(a[j] == b[i+1]){
                    ans += a[j]-b[i+1];
                    i = j;
                    j++;
                }else{
                    i++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of arrays : ");
        int n = scn.nextInt();
        int []a = new int[n];
        int []b = new int[n];
        System.out.println("Enter elements in array A : ");
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
        }
        System.out.println("Enter elements in array B : ");
        for(int i=0; i<n; i++){
            b[i] = scn.nextInt();
        }
        System.out.println("Min pair sum is : " + MinPairSum(a,b));
    }
}