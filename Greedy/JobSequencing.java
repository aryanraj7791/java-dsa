import java.util.*;

public class JobSequencing{
    static public class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static int maxProfit(ArrayList<Job> jobs){
        int time=0;
        int maxProfit=0;
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0; i<jobs.size(); i++){
            Job job = jobs.get(i);
            if(job.deadline > time){
                time++;
                maxProfit += job.profit;
                seq.add(job.id);
            }
        }
        System.out.print("Jobs id : ");
        for(int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
        return maxProfit;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of jobs : ");
        int n = scn.nextInt();
        int jobInfo[][] = new int[n][3];
        for(int i=0; i<jobInfo.length; i++){
            jobInfo[i][0] = i;
            System.out.print("Enter deadline of job"+i+" : ");
            jobInfo[i][1] = scn.nextInt();
            System.out.print("Enter profit of job"+i+" : ");
            jobInfo[i][2] = scn.nextInt();
        }
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobInfo.length; i++){
            jobs.add(new Job(jobInfo[i][0],jobInfo[i][1],jobInfo[i][2]));
        }
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit); //sort in descending order of profit
        System.out.println("Maximum profit is : " + maxProfit(jobs));
    }
}