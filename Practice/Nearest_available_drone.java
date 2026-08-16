import java.util.*;
import java.io.*;

class Nearest_available_drone {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int nextInt() throws IOException {

        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());

    }

    public static int minDist(int[][] drones, int[] target){

        int n = drones.length;

        int minDistance = Integer.MAX_VALUE;

        int idx = -1;

        for(int i=0; i<n; i++){

            int dist = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);

            if(dist < minDistance){
                minDistance = dist;
                idx = i;
            }

        }

        return idx;

    }

    public static void main(String[] args) throws IOException {

        System.out.print("Enter number of drones: ");
        int n = nextInt();

        int[][] drones = new int[n][3];

        System.out.println("Enter (X,Y) coordinate along with its range: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter 'x' coordinate of drone" + (i+1) + " : ");
            drones[i][0] = nextInt();

            System.out.print("Enter 'y' coordinate of drone" + (i+1) + " : ");
            drones[i][1] = nextInt();

            System.out.print("Enter range of drone" + (i+1) + " : ");
            drones[i][2] = nextInt();
        }

        int[] target = new int[2];

        System.out.print("Enter 'x' coordinate of target: ");
        target[0] = nextInt();

        System.out.print("Enter 'y' coordinate of target: ");
        target[1] = nextInt();

        System.out.println("Index of minimum Manhattan distance is: " + minDist(drones,target));

    }

}