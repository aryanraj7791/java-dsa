import java.util.*;

public class OddOrEvenCheck{

    public static boolean numCheck(int n){
        if((n & 1) == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        if(numCheck(n)) System.out.print(n + " is even");
        else System.out.print(n + " is odd");
    }
}