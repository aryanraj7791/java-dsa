import java.util.*;

class Maximum_meetings_in_one_room {
    
    public static ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        
        int n = s.length;
        
        int[][] meet = new int[n][3];
        
        for(int i=0; i<n; i++){
            meet[i][0] = i;
            meet[i][1] = s[i];
            meet[i][2] = f[i];
        }
        
        Arrays.sort(meet, (a,b) -> Integer.compare(a[2],b[2]));
        
        int start = meet[0][1];
        int end = meet[0][2];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(meet[0][0] + 1);
        
        for(int i=1; i<meet.length; i++){
            
            if(meet[i][1] > end){ //non-overlapping
                list.add(meet[i][0] + 1);
                start = meet[i][1];
                end = meet[i][2];
            }
            
        }
        
        Collections.sort(list);
        
        return list;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of meetings : ");
        int n = scn.nextInt();

        int[] s = new int[n];
        int[] f = new int[n];

        System.out.println("Enter start and finish time of meetings: ");
        
        for(int i=0; i<n; i++){

            System.out.print("Enter start time of meeting" + (i+1) + ": ");
            s[i] = scn.nextInt();

            System.out.print("Enter finish time of meeting" + (i+1) + ": ");
            f[i] = scn.nextInt();

        }

        ArrayList<Integer> ans = maxMeetings(s,f);

        System.out.println("Maximum meetings that can be scheduled in a room is: " + ans.size());
        
        System.out.print("Meetings are at indexes(1-based): " + ans);

    }
}