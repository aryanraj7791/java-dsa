import java.util.*;

public class LoopBasics1{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        // System.out.print("Enter number of rows: ");
        // int n = scn.nextInt();
        
        // int i=0;
        // int j;
        // while(n>0){
        //     j=0;
        //     while(i>=j){
        //         System.out.print("* ");
        //         j++;
        //     }
        //     System.out.print("\n");
        //     i++;
        //     n--;
        // }

        // Sum of first 'n' natural numbers
        // System.out.print("Enter n: ");
        // int n = scn.nextInt();

        // int sum=0,i=1;
        // while(i<=n){
        //     sum += i;
        //     i++;
        // }
        // System.out.print("Sum of first " + n + " natural number is: " + sum);

        //Reverse of a number
        // System.out.print("Enter a number: ");
        // int n = scn.nextInt();
        // int res=0,ls=0;
        // while(n>0){
        //     ls = n%10;
        //     res = res*10 + ls;
        //     n /= 10;
        // }
        // System.out.print("Reverse is: " + res);

        //Check for Prime number
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        int i=2,flag=0;
        while(i<n){
            if(n%i == 0){
                System.out.print(n + " is composite number.");
                flag=1;
                break;
            }
            i++;
        }
        if(flag == 0){
            System.out.print(n + " is prime number.");
        }
    }
}