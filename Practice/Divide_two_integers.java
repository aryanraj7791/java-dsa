import java.util.*;

class Divide_two_integers {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if ((b << i) <= a) {
                a -= (b << i);
                ans += (1 << i);
            }
        }

        return ((dividend < 0) ^ (divisor < 0)) ? -ans : ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter dividend : ");
        int dividend = scn.nextInt();

        System.out.print("Enter divisor : ");
        int divisor = scn.nextInt();
        
        System.out.println("Quotient when " + dividend + " is divided by " + divisor + " is : " + divide(dividend,divisor));
    }
}