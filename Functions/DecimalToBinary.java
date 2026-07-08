import java.util.*;

public class DecimalToBinary{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        long n = scn.nextLong();
        long quo=0,bin=0,rem=0,pow=0;
        while(n>0){
            rem = n%2;
            bin = bin + rem * (long) Math.pow(10,pow);
            n /= 2;
            pow++;
        }

        System.out.print("Binary equivalent is: " + bin);
    }
}