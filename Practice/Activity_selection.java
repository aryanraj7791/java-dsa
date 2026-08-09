import java.util.*;

class Activity_selection {

    public static int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        int[][] tasks = new int[n][2];
        
        for(int i=0; i<tasks.length; i++){
            tasks[i][0] = start[i];
            tasks[i][1] = finish[i];
        }
        
        Arrays.sort(tasks, (a,b) -> Integer.compare(a[1],b[1]));
        
        int maxActivities = 1;
        
        int endTime = tasks[0][1];
        
        for(int i=1; i<tasks.length; i++){
            if(tasks[i][0] > endTime){
                endTime = tasks[i][1];
                maxActivities++;
            }
        }
        
        return maxActivities;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of tasks : ");
        int n = scn.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];
        System.out.println("Enter start time of tasks: ");

        for(int i=0; i<n; i++){
            start[i] = scn.nextInt();
        }
        System.out.println("Enter finish time of tasks: ");
        for(int i=0; i<n; i++){
            finish[i] = scn.nextInt();
        }

        System.out.println("Maximum number of tasks that can be completed is: " + activitySelection(start,finish));
    }
}