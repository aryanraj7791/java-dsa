import java.util.*;

public class SudokuSolver{

    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int sudoku[][], int row, int col,int digit){
        for(int j=0; j<9; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        for(int i=0; i<9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        row = (row/3)*3;
        col = (col/3)*3;
        for(int i=row; i<=row+2; i++){
            for(int j=col; j<=col+2; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
   
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //Basecase
        if(row == 9){
            return true;
        }
        //Recursion
        int nextRow = row, nextCol = col+1;
        if(nextCol == 9){
            nextRow++;
            nextCol=0;
        }
        if(sudoku[row][col] != 0){
           return sudokuSolver(sudoku,nextRow,nextCol);
        }
        for(int digit = 1; digit<=9; digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col] = 0; //Backtrack
            }
        }
        return false;
    }

    public static void main(String[] args){
        int sudoku[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        sudokuSolver(sudoku,0,0);
        printSudoku(sudoku);
    }
}