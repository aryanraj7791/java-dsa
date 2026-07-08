import java.util.*;

public class SumOfFirstN{

    public static int printUptoN(int n){
        if(n == 1){
            return 1;
        }
        int prevSum = printUptoN(n-1);
        int sum = n + prevSum;
        return sum;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("Sum of first " + n + " natural numbers is: " + printUptoN(n));
    }
}