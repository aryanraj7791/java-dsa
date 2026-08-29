import java.util.*;
import java.io.*;

class Minimum_Bishop_Moves {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int minMoves(int sr, int sc, int tr, int tc){

        if((sr+sc)%2 != (tr+tc)%2) return -1;

        if((sr+sc) == (tr+tc) || (sr-sc) == (tr-tc)) return 1;

        return 2;

    }

    public static void main(String[] args) throws java.lang.Exception {

        // Bishop can move only diagonally and there is no restriction on how many move it takes towards target.

        System.out.print("Enter source row: ");
        int sr = nextInt();

        System.out.print("Enter source column: ");
        int sc = nextInt();

        System.out.print("Enter target row: ");
        int tr = nextInt();

        System.out.print("Enter target column: ");
        int tc = nextInt();

        System.out.println("Minimum moves to reach target is: " + minMoves(sr,sc,tr,tc));

    }

}