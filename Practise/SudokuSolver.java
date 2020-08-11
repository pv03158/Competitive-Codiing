import java.util.*;

public class SudokuSolver {
    public static void main(String args[]) {
        int board[][] = {   { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                            { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
                            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                            { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                            { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                            { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                            { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                            { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                            { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        System.out.println(solve(board, 0));
    }

    public static int solve(int[][] board, int vidx) {
        if(vidx == 81) {
            for(int idx = 0 ; idx < 9 ; idx ++)
                System.out.println(Arrays.toString(board[idx]));
            return 1;
        }

        int row = vidx / 9;
        int col = vidx % 9;

        int counter = 0;
        if (board[row][col] != 0)
            counter += solve(board, vidx+1);
        else {
            ArrayList<Integer> validNums = getValidNumbersToFill(board, row, col);
            for(int num : validNums) {
                board[row][col] = num;
                counter += solve(board, vidx + 1);
                board[row][col] = 0;
            }
        }

        return counter;
    }

    public static ArrayList<Integer> getValidNumbersToFill(int[][] board, int row, int col) {
        boolean invalidNum[] = new boolean[10];
        invalidNum[0] = true;

        // CHECKING ROW AND COLUMN WISE
        for(int idx = 0 ; idx < 9 ; idx++)  {
            int rvalue = board[idx][col];
            int cvalue = board[row][idx];
            if( rvalue != 0 )
                invalidNum[rvalue] = true;
            if( cvalue != 0 )
                invalidNum[cvalue] = true;
        }

        // CHECKING IN THE LOCAL MATRIX
        int srow = row - row%3;
        int scol = col - col%3;
        for(int i = 0 ; i < 3 ; i++)
            for(int j = 0 ; j < 3 ; j++)
                if( board[srow + i][ scol + j] != 0 )
                    invalidNum[ board[srow + i][ scol + j] ] = true;
 
        ArrayList<Integer> res = new ArrayList<>();
        for(int idx = 0 ; idx < 10 ; idx ++) 
            if( invalidNum[idx] == false )
                res.add(idx);

        return res;
    }
}