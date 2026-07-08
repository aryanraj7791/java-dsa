import java.util.*;

public class GridWaysOptimised{
    //Time Complexity = O(n)
    public static int fact(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int countWays(int n, int m){
        return fact(n+m-2)/(fact(n-1)*fact(m-1));
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows in grid : ");
        int n = scn.nextInt();
        System.out.print("Enter number of columns in grid : ");
        int m = scn.nextInt();
        System.out.print("Total number of ways to reach last cell from start cell is : " + countWays(n,m));
    }
}