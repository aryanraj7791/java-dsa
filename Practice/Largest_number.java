import java.util.*;
import java.io.*;

class Largest_number {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static StringTokenizer st;
    
    static int nextInt() throws IOException {
        
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        
        return Integer.parseInt(st.nextToken());
    }

    public static String largestNumber(int[] nums) {

        int n = nums.length;

        String[] str = new String[n];

        for(int i=0; i<n; i++){

            str[i] = String.valueOf(nums[i]);

        }

        Arrays.sort(str, (s1,s2) -> (s2+s1).compareTo(s1+s2));

        if(str[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        for(String s: str){

            sb.append(s);

        }

        return sb.toString();
        
    }

    public static void main(String[] args) throws java.lang.Exception {

        System.out.print("Enter size of array: ");
        int n = nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements in the array: ");

        for(int i=0; i<n; i++){
            nums[i] = nextInt();
        }

        System.out.println("Largest number is: " + largestNumber(nums));

    }
}