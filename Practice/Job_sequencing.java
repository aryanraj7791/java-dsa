import java.util.*;

class Job_sequencing {
    
    public static int find(int[] parent, int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent,parent[x]);
    }
    
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        
        int n = profit.length;
        
        int[][] arr = new int[n][2];
        
        for(int i=0; i<n; i++){
            arr[i][0] = deadline[i];
            arr[i][1] = profit[i];
        }
        
        Arrays.sort(arr, (a,b) -> Integer.compare(b[1],a[1]));
        
        int maxDeadline = 0;
        
        for(int[] job: arr){
            maxDeadline = Math.max(maxDeadline,job[0]);
        }
        
        int[] parent = new int[maxDeadline+1];
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        int jobsDone = 0;
        int maxProfit = 0;
        
        for(int i=0; i<n; i++){
            int j = arr[i][0];
            int slot = find(parent,j);
            if(slot > 0){
                jobsDone++;
                maxProfit += arr[i][1];
                parent[slot] = find(parent,slot-1);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(jobsDone);
        res.add(maxProfit);
        
        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = scn.nextInt();

        int[] deadline = new int[n];

        System.out.println("Enter deadline of jobs: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter deadline for job " + (i+1) + ": ");
            deadline[i] = scn.nextInt();
        }

        int[] profit = new int[n];

        System.out.println("Enter profit for completing jobs within deadline: ");

        for(int i=0; i<n; i++){
            System.out.print("Enter profit for job " + (i+1) + ": ");
            profit[i] = scn.nextInt();
        }

        ArrayList<Integer> res = jobSequencing(deadline,profit);

        System.out.println("Total of " + res.get(0) + " jobs can be completed with maximum profit of " + res.get(1) + ".");
    }
}