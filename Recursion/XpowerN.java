import java.util.*;

public class XpowerN{

    public static int powerCalc(int x, int n){
       if(n == 0){
        return 1;
       } 
       if(n == 1){
        return x;
       }
       return x * powerCalc(x,n-1);
    }

        public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter base: ");
        int x = scn.nextInt();
        System.out.print("Enter power: ");
        int n = scn.nextInt();
        System.out.print(x + " to the power " + n + " is : " + powerCalc(x,n));
    }
}