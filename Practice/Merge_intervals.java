import java.util.*;

class Merge_intervals {

    public static int[][] merge(int[][] intervals) {

        // Sort intervals array on the basis of start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start,end});

        int[][] res = new int[list.size()][];

        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;

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

        int[][] res = merge(intervals);

        System.out.println("Merged intervals: ");

        for(int i=0; i<res.length; i++){
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }

    }
}