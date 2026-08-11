import java.util.*;

class Min_removals_of_interval{

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        int minRemovals = 0;

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < end){
                minRemovals++;
                end = Math.min(end, intervals[i][1]);
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        return minRemovals;
        
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of intervals : ");
        int m = scn.nextInt();

        int[][] intervals = new int[m][2];

        System.out.println("Enter intervals : ");

        for(int i=0; i<m; i++){
            System.out.print("Enter start time: ");
            intervals[i][0] = scn.nextInt();
            System.out.print("Enter end time: ");
            intervals[i][1] = scn.nextInt();
        }

        System.out.println("Minimum removals of interval to make overall non-overlapping is: " + eraseOverlapIntervals(intervals));
    }
}