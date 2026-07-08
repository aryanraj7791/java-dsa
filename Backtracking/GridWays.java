import java.util.*;

public class GridWays{
    //Time Complexity = O(2^n+m)
    public static int countWays(int row, int col, int n, int m){
        if(row >= n || col >= m){ //Index out of bound check
            return 0;
        }
        //BaseCase
        if(row == n-1 && col == m-1){
            return 1;
        }
        //Recursion
        int right = countWays(row,col+1,n,m); //Move right
        int down = countWays(row+1,col,n,m); //Move down
        return right + down;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows in grid : ");
        int n = scn.nextInt();
        System.out.print("Enter number of columns in grid : ");
        int m = scn.nextInt();
        System.out.print("Total number of ways to reach last cell from start cell is : " + countWays(0,0,n,m));
    }
}