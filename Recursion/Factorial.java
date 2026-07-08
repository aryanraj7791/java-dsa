import java.util.*;

public class Factorial{

    public static int factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        scn.close();
        if(n<0){
            System.out.print("Factorial doesnot exist for negative numbers!");
        }
        else System.out.print("Factorial of " + n + " is : " + factorial(n));
    }
}