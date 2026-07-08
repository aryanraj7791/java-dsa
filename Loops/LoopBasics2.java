import java.util.*;

public class LoopBasics2{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        //Sum of odd and even
        // System.out.print("Enter number of integers as input: ");
        // int n = scn.nextInt();

        // int evenSum=0, oddSum=0, num=0;

        // System.out.print("\n");
        // for(int i=0; i<n; i++){
        //     System.out.print("Enter integer: ");
        //     num = scn.nextInt();
        //     if(num%2==0){
        //         evenSum += num;
        //     }
        //     else{
        //         oddSum += num;
        //     }
        // }

        // System.out.println("\nEven sum is: " + evenSum);
        // System.out.println("Odd sum is: " + oddSum);

        //Factorial of number
        //  System.out.print("Enter a number: ");
        //  int a = scn.nextInt();

        //  int fact = 1, i=1;

        //  while(i<=a){
        //     fact *= i;
        //     i++;
        //  }

        //  System.out.print("Factorial of " + a + " is : " + fact);

        //Multiplication Table
        System.out.print("Enter x: ");
        int x = scn.nextInt();
        System.out.print("\nTable of " + x + " is : ");
        System.out.print("\n\n");
        int table = 1, i=1;
        while(i<=10){
            System.out.println(x + " * " + i + " = " + (x*i));
            i++;
        }
    }
}