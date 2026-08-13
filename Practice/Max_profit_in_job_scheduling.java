import java.util.*;

class Max_profit_in_job_scheduling{

    public static int findNextJob(int[][] jobs, int idx){
        int target = jobs[idx][1];
        int low = idx+1;
        int high = jobs.length;

        while(low < high){
            int mid = low + (high-low)/2;
            if(jobs[mid][0] >= target){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    public static int helper(int[][] jobs, int i, int[] dp){
        if(i >= jobs.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int next = findNextJob(jobs,i);

        int take = jobs[i][2] + helper(jobs,next,dp);

        int skip = helper(jobs,i+1,dp);

        return dp[i] = Math.max(take,skip);
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = profit.length;

        int[][] jobs = new int[n][3];

        for(int i=0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0],b[0]));

        int[] dp = new int[jobs.length];

        Arrays.fill(dp,-1);

        return helper(jobs,0,dp);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = scn.nextInt();

        int[] startTime = new int[n];
        int[] endTime = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter startTime, endTime and profit associated with jobs: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter startTime for job " + (i+1) + ": ");
            startTime[i] = scn.nextInt();
            System.out.print("Enter endTime for job " + (i+1) + ": ");
            endTime[i] = scn.nextInt();
            System.out.print("Enter profit associated with job " + (i+1) + ": ");
            profit[i] = scn.nextInt();
        }


        System.out.println("Maximum profit is: " + jobScheduling(startTime,endTime,profit));
    }
}