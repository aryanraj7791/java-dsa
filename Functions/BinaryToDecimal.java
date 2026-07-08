import java.util.*;

public class BinaryToDecimal{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter binary number: ");
        long n = scn.nextLong();
        long ls=0,dec=0,pow=0;
        while(n>0){
            ls = n%10;
            dec = dec + ls * (long) (Math.pow(2,pow));
            pow++;
            n /= 10;
        }

        System.out.print("Decimal equivalent is: " + dec);
    }
}