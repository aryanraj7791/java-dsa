// import java.util.*;

// public class Constest2{

//     public static int helper(int []arr, int []brr){
//         int ans=0;
//         int i=0,j=0;
//         for(int i=0,j=0; i<arr.length && j<brr.length; i++,j++){
//             if(arr[i]>brr[j]) ans += arr[i]-brr[j];
//         }
//         return ans+1;
//     }

//     public static void main(String[] args){
//         Scanner scn = new Scanner(System.in);
//         int t = scn.nextInt();
//         for(int i=0; i<t; i++){
//             int n = scn.nextInt();
//             int []arr = new int[n];
//             int []brr = new int[n];
//             for(int j=0; j<n; j++){
//                 arr[j] = scn.nextInt();
//             }
//             for(int j=0; j<n; j++){
//                 brr[j] = scn.nextInt();
//             }
//             System.out.println(helper(arr,brr));
//         }
//     }
// }


//Recycling Center
import java.util.*;

public class Contest2{

    public static int helper(int []weights, int c){
        int cost=0;
        Arrays.sort(weights);
        int i=0,j=weights.length-1;
        while(i<j){
            int temp = weights[i];
            weights[i] = weights[j];
            weights[j] = temp;
            i++;
            j--;
        }
        for(int k=0; k<weights.length; k++){
            if(weights[k]>c){
                cost++;
                continue;
            }
            for(int p=k+1; p<weights.length; p++){
                weights[p] *= 2;
            }
        }
        return cost;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i=0; i<t; i++){
            int n = scn.nextInt();
            int c = scn.nextInt();
            int weights[] = new int[n];
            for(int j=0; j<n; j++){
                weights[j] = scn.nextInt();
            }
            System.out.println(helper(weights,c));
        }
    }
}