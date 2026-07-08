import java.util.*;

public class IndianCoins1{
    static ArrayList<Integer> seq = new ArrayList<>();
    public static int minCoins(Integer coins[], int amount){
        Arrays.sort(coins, Comparator.reverseOrder());
        int minCoinsNotes = 0;
        for(int i=0; i<coins.length && amount > 0; i++){
            if(amount >= coins[i]){
                while(coins[i] <= amount){
                    minCoinsNotes++;
                    seq.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        return minCoinsNotes;
    }
    public static void main(String[] args){
        Integer coins[] = {1,2,5,10,20,50,100,500,1000,2000};
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value : ");
        int n = scn.nextInt();
        System.out.println("Minimum coins/notes : "+minCoins(coins,n));
        for(int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}