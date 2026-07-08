import java.util.*;

public class NthFibonacciNumber{

    public static int fibonacciNumber(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int res = fibonacciNumber(n-1) + fibonacciNumber(n-2);
        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("Fibonacci number is : " + fibonacciNumber(n));
    }
}