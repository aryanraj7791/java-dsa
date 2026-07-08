import java.util.*;

public class TilingProblem{

    public static int fillFloor(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int verAns = fillFloor(n-1);
        int horAns = fillFloor(n-2);
        return verAns + horAns;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter breadth of floor(2*n) as n: ");
        int n = scn.nextInt();
        System.out.print("Total number of ways to fill the 2 * " + n + " floor is : " + fillFloor(n));
    }
}