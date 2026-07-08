import java.util.*;

public class ClearRangeOfBits{

    public static int clearRangeBits(int n, int i, int j){
        int mask = ~((~0)<<i) | ((~0)<<j+1);
        return n & mask;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        System.out.print("Enter lower bound(i): ");
        int i = scn.nextInt();
        System.out.print("Enter upper bound(j): ");
        int j = scn.nextInt();
        System.out.print("Number obtained after clearing bits from 'i' to 'j' is: " + clearRangeBits(n,i,j));
    }
}