import java.util.*;
import java.io.*;

class Jump_game {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static boolean jumpGame(int[] jumps){

        int maxIdx = 0;

        for(int i=0; i<jumps.length; i++){

            if(i > maxIdx) {
                return false;
            }
            else{
                maxIdx = Math.max(maxIdx, i + jumps[i]);

                if(maxIdx >= jumps.length) return true;
            }

        }

        return true;

    }

    public static void main(String[] args) throws IOException{

        System.out.print("Enter size of jumps array: ");
        int n = nextInt();

        int[] jumps = new int[n];

        System.out.println("Enter maximum jumps from every index: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter for index" + i + ": ");
            jumps[i] = nextInt();
        }

        System.out.println(jumpGame(jumps));

    }

}