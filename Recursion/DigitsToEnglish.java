import java.util.*;

public class DigitsToEnglish{

    static String str[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void printEnglish(int n){
        if(n == 0){
            return;
        }
        int lastDigit = n % 10;
        printEnglish(n/10);
        System.out.print(str[lastDigit] + " ");
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        if(n == 0){
            System.out.print(str[0] + " ");
            return;
        }
        printEnglish(n);
    }
}