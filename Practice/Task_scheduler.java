import java.util.*;

class Task_scheduler {

    public static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int gaps = maxFreq - 1;
        int idleSlots = gaps * n;

        for(int i=24; i>=0; i--){

            idleSlots -= Math.min(freq[i], gaps);

        }
        
       if(idleSlots > 0){
        return tasks.length + idleSlots;
       }

       return tasks.length;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of CPU tasks : ");
        int n = scn.nextInt();
        char[] tasks = new char[n];

        System.out.println("Enter tasks(only between'A'-->'Z'): ");

        for(int i=0; i<n; i++){
            tasks[i] = scn.next().charAt(0);
        }

        System.out.print("Enter cooldown period : ");
        int c = scn.nextInt();

        System.out.println("Minimum number of CPU intervals to complete all tasks is: " + leastInterval(tasks,c));

    }
}