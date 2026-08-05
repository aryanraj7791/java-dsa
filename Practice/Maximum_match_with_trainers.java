import java.util.*;

class Maximum_match_with_trainers {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);

        int ans = 0;

        int j = 0;

        for(int i=0; i<players.length && j<trainers.length; i++){
            if(players[i] <= trainers[j]){
                ans++;
                j++;
            }
            else{
                i--;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of players : ");
        int n = scn.nextInt();
        int[] players = new int[n];
        System.out.println("Enter ability of players : ");
        for(int i=0; i<n; i++){
            players[i] = scn.nextInt();
        }

        System.out.print("Enter number of trainers : ");
        int m = scn.nextInt();
        int[] trainers = new int[m];
        System.out.println("Enter capacity of trainers : ");
        for(int i=0; i<m; i++){
            trainers[i] = scn.nextInt();
        }

        System.out.println("Maximum player vs trainer match is : " + matchPlayersAndTrainers(players,trainers));
    }
}