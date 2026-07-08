import java.util.*;

public class NQueens{
    //Time complexity = O(n!)
    static int count = 0;
    public static void printBoard(char board[][]){
        count++;
        System.out.println("-----ChessBoard-----");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char chessboard[][], int i, int j){
        //vertical direction
        for(int row=i; row>=0; row--){
            if(chessboard[row][j] == 'Q'){
                return false;
            }
        }
        //upper left diagonal
        for(int row=i,col=j; row>=0 && col>=0; row--,col--){
            if(chessboard[row][col] == 'Q'){
                return false;
            }
        }
        //upper right diagonal
        for(int row=i,col=j; row>=0 && col<chessboard.length; row--,col++){
            if(chessboard[row][col] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char chessboard[][], int row){
        //Base Case
        if(row == chessboard.length){
            printBoard(chessboard);
            return;
        }

        //Recursion
        for(int j=0; j<chessboard.length; j++){
            if(isSafe(chessboard,row,j)){
                chessboard[row][j] = 'Q';
                nQueens(chessboard,row+1); //Recursive function call
                chessboard[row][j] = 'x'; //Backtracking step
            }
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size for n*n chessboard : ");
        int n = scn.nextInt();
        scn.close();
        char chessboard[][] = new char[n][n];
        for(int i=0; i<chessboard.length; i++){
            for(int j=0; j<chessboard.length; j++){
                chessboard[i][j] = 'x';
            }
        }
        nQueens(chessboard,0);
        System.out.print("Total ways to solve " + n + "x" + n + " queens problem is : " + count);
    }
}