import java.util.*;

class Min_arrows_to_burst_balloons {

    public static int findMinArrowShots(int[][] points) {

        int n = points.length;

        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));

        int start = points[0][0];
        int end = points[0][1];

        int arrows = 1;

        for(int i=1; i<points.length; i++){
            //check for overlapping
            if(points[i][0] <= end){
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
            else{ //non-overlapping
                arrows++;
                start = points[i][0];
                end = points[i][1];
            }
        }    

        return arrows;

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of balloons: ");
        int n = scn.nextInt();
        int[][] points = new int[n][2];

        System.out.println("Enter Xstart and Xend for each balloon: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter Xstart for balloon "+(i+1)+ ": ");
            points[i][0] = scn.nextInt();
            System.out.print("Enter Xend for balloon "+(i+1)+ ": ");
            points[i][1] = scn.nextInt();
        }

        System.out.println("Minimum arrows needed to burst all balloons is: " + findMinArrowShots(points));
    }
}