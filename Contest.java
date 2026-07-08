// import java.util.*;

// public class Contest{

//     public static int func(int x){
//         int min = Integer.MAX_VALUE;
//         if(x / 10 == 0){
//             return x;
//         }else{
//             while(x > 0){
//                 int ld = x%10;
//                 min = Math.min(ld,min);
//                 x = x/10;
//             }
//         }
//         return min;
//     }

//     public static void main(String[] args){
//         Scanner scn = new Scanner(System.in);
//         int t = scn.nextInt();
//         for(int i=1; i<=t; i++){
//             int x = scn.nextInt();
//             System.out.println(func(x));
//         }
//     }
// }

// import java.util.*;

// public class Contest {

//     public static int maxPeaks(int[] arr, int k) {
//         if (arr.length < k) return 0;
//         int count = 0;
//         int j = 0;

//         while (j + k <= arr.length) {
//             boolean flag = true;
//             int x;
//             for (x = 0; x < k; x++) {
//                 if (arr[j + x] == 1) {
//                     flag = false;
//                     break;
//                 }
//             }
//             if (flag) {
//                 count++;
//                 j += k + 1;
//             } else {
//                 j = j + x + 1;
//             }
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int t = scn.nextInt();
//         for (int i = 1; i <= t; i++) {
//             int n = scn.nextInt();
//             int k = scn.nextInt();
//             int[] arr = new int[n];
//             for (int j = 0; j < n; j++) {
//                 arr[j] = scn.nextInt();
//             }
//             System.out.println(maxPeaks(arr, k));
//         }
//     }
// }

// import java.util.*;

// public class Contest{

//     public static String willMake(int []arr, int k){
//         int ht = arr[k-1];
//         Arrays.sort(arr);
//         int wl = 1;
//         int i;
//         for(i=0; i<arr.length; i++){
//             if(arr[i] == ht) break;
//         }
//         int cl = arr[i]+1;
//         while(i<arr.length-1){
//             int diff = arr[i+1]-arr[i];
//             if(diff>cl-wl) return "No";
//             i++;
//             cl = arr[i]+1;
//             wl += diff;
//             if(cl == arr[arr.length-1]) return "Yes";
//         }
//         return "Yes";
//     }

//     public static void main(String[] args){
//         Scanner scn = new Scanner(System.in);
//         int t = scn.nextInt();
//         for(int i=0; i<t; i++){
//             int n = scn.nextInt();
//             int k = scn.nextInt();
//             int[] arr = new int[n];
//             for (int j = 0; j < n; j++){
//             arr[j] = scn.nextInt();
//         }
//         System.out.println(willMake(arr,k));
//         }
//     }
// }

import java.util.*;

public class Contest{

    public static void nextGreatest(int []arr){
        int n = arr.length;
        int max=arr[n-1];
        for(int i=n-1; i>=0; i--){
            if(arr[i] > max){
                max = arr[i];
            }else{
                arr[i] = max;
            }
        }
    }

    public static void printArr(int []arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scn.nextInt();
        int []arr = new int[n];
        System.out.println("Enter elements in array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        nextGreatest(arr);
        printArr(arr);
    }
}