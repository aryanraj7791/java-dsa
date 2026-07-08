import java.util.*;

public class SumOfDigits{
    public static int sumOfDigits(int x){
        int sum=0;
        while(x>0){
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        System.out.print("Sum of all digits of " + n + " is: " + sumOfDigits(n));
    }
}