import java.util.*;
import java.io.*;

class Minimize_Heights {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int minimizeHeights(int[] arr, int k){

        int n = arr.length;

        Arrays.sort(arr);

        int ans = arr[n-1] - arr[0];

        for(int i=1; i<n; i++){

            if(arr[i] - k < 0) continue;

            int minH = Math.min(arr[0] + k, arr[i] - k);

            int maxH = Math.max(arr[n-1] - k, arr[i-1] + k);

            ans = Math.min(ans, maxH - minH);

        }

        return ans;

    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){
            arr[i] = nextInt();
        }

        System.out.print("Enter k value for performing either +k/-k operation on every element: ");
        int k = nextInt();

        System.out.println("Minimum difference between maximum and minimum heights is: " + minimizeHeights(arr, k));

    }

}