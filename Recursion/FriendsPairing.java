import java.util.*;

public class FriendsPairing{

    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int single = 1*friendsPairing(n-1); //1--> As one friend wants to stay single, and then remaining (n-1) can be arranged in friendsPairing(n-1) ways.
        int pair = 1*(n-1)*friendsPairing(n-2); //1--> As one friend wants to stay in pair, so another friend to complete pair has (n-1) choices, and then remaining (n-2) can be arranged in friendsPairing(n-2) ways.
        return single + pair;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of friends: ");
        int n = scn.nextInt();
        System.out.print("Total number of ways is : " + friendsPairing(n));
    }
}