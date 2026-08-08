import java.util.*;

public class Shortest_job_first {

    public static int solve(int[] bt){
        Arrays.sort(bt);

        int totalWaitingTime = 0;
        int acc = 0;

        for(int i=1; i<bt.length; i++){
            acc += bt[i-1];
            totalWaitingTime += acc;
        }

        return totalWaitingTime/bt.length;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of jobs : ");
        int n = scn.nextInt();
        int[] bt = new int[n];
        
        System.out.println("Enter burst time of jobs : ");
        for(int i=0; i<n; i++){
            bt[i] = scn.nextInt();
        }

        System.out.println("Total average waiting time is : " + solve(bt));
    }
}