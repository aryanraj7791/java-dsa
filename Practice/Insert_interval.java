import java.util.*;

class Insert_interval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];

        int i=0;
        int n = intervals.length;

        List<int[]> list = new ArrayList<>();

        while(i < n && start > intervals[i][1]){
            list.add(intervals[i]);
            i++;
        }

        while(i < n && end >= intervals[i][0]){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        list.add(new int[]{start,end});

        for(int x = i; x<intervals.length; x++){
            list.add(intervals[x]);
        }
        
        int[][] res = new int[list.size()][];

        for(int x = 0; x<list.size(); x++){
            res[x] = list.get(x);
        }

        return res;

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of intervals: ");
        int n = scn.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("Enter start and end time of intervals: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter start time: ");
            intervals[i][0] = scn.nextInt();
            System.out.print("Enter end time: ");
            intervals[i][1] = scn.nextInt();
        }

        int[] newInterval = new int[2];

        System.out.print("Enter start time of new interval to be added: ");
        newInterval[0] = scn.nextInt();

        System.out.print("Enter end time of new interval to be added: ");
        newInterval[1] = scn.nextInt();

        int[][] res = insert(intervals,newInterval);

        System.out.println("Intervals after new interval got inserted: ");

        for(int i=0; i<res.length; i++){
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }
}