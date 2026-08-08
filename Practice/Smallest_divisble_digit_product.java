import java.util.*;

class Smallest_divisble_digit_product {

    public static int smallestNumber(int n, int t) {

        int ans = 0;

        for(int i=n ; ; i++){

            int prod = 1;

            int num = i;

            while(num > 0){
                int ld = num % 10;
                prod *= ld;
                num /= 10;
            }

            if(prod % t == 0){
                ans = i;
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = scn.nextInt();

        System.out.print("Enter t : ");
        int t = scn.nextInt();
        
        System.out.println("Smallest number(>=n) whose product of digits is divisible by " + t + " is : " + smallestNumber(n,t));
    }
}