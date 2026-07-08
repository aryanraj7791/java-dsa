import java.util.*;

public class RatMaze{
    static int count=0;
    static int dr[] = {-1,1,0,0}; // Difference in row
    static int dc[] = {0,0,-1,1}; // Difference in column
    static char dir[] = {'U','D','L','R'}; // Direction array
    public static boolean isSafe(int maze[][], int row, int col){
        if(row>=0 && col>=0 && row<maze.length && col<maze.length && maze[row][col] == 0){
            return true;
        }
        return false;
    }

    public static void ratMaze(int maze[][], int row, int col, StringBuilder path){
        //Basecase
        if(row == maze.length-1 && col == maze.length-1){
            count++;
            System.out.println(path);
            return;
        }

        //Recursion
        maze[row][col] = -1;
        for(int idx=0; idx<4; idx++){
            if(isSafe(maze,row+dr[idx],col+dc[idx])){
                path.append(dir[idx]);
                ratMaze(maze,row+dr[idx],col+dc[idx],path);
                path.deleteCharAt(path.length()-1);
            }
        }
        maze[row][col] = 0;
    }

    public static void main(String[] args){
        count=0;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of NxN square binary matrix : ");
        int n = scn.nextInt();
        int maze[][] = new int[n][n];
        System.out.println("Enter binary values : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                maze[i][j] = scn.nextInt();
            }
        }
        ratMaze(maze,0,0,new StringBuilder(""));
        System.out.println("Total ways are " + count + " and they are shown above.");
    }
}