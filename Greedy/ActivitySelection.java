import java.util.*;

public class ActivitySelection{
    public static int maxActivities(int []start, int []end){
        int activities[][] = new int[start.length][3]; //2D array to store startTime, endTime and index of activities
        for(int i=0; i<start.length; i++){
            activities[i][0] = i; //0th col -> index of activity
            activities[i][1] = start[i]; //1st col -> start time of activity
            activities[i][2] = end[i]; //2nd col -> end time of activity
        }
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2])); //Sort 2D array on the basis of end time
        int maxAct = 1; //0th activity will be completed at the earliest thus most possible time remains for other activities
        System.out.println("A0");
        int lastAct = 0;
        int currAct = 1;
        while(currAct < activities.length){ //O(n)
            if(activities[lastAct][2] <= activities[currAct][1]){
                maxAct++;
                System.out.println("A" + currAct);
                lastAct = currAct;
            }
            currAct++;
        }
        return maxAct;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of activities : ");
        int n = scn.nextInt();
        int []start = new int[n];
        int []end = new int[n];
        System.out.println("Enter start time of activities : ");
        for(int i=0; i<n; i++){
            start[i] = scn.nextInt();
        }
        System.out.println("Enter end time of activities : ");
        for(int i=0; i<n; i++){
            end[i] = scn.nextInt();
        }
        System.out.println("Maximum activities that can be performed is : " + maxActivities(start,end));
    }
}