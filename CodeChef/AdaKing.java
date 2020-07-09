import java.util.*;

public class AdaKing {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int k = scn.nextInt();
            char chessBoard[][] = new char[8][8];
            // creating blank chess board
            for(int i = 0 ; i < 8 ; i++) 
                for(int j = 0 ; j < 8 ; j++) 
                    chessBoard[i][j] = '.'; 
            
            // marking various positions king, where it is allowed to move
            // on chessboard
            boolean flag = true;
            for(int i = 0 ; i < 8 && flag ; i++)  {
                for(int j = 0 ; j < 8 && flag ; j++) {
                    chessBoard[i][j] = 'O';
                    if(--k <= 0)
                        flag = false;
                }
            }

            // marking blocks on chess board
            for(int i = 0 ; i < 8 ; i++) 
                for(int j = 0 ; j < 8 ; j++) 
                    if(chessBoard[i][j] != 'O' 
                        && ( (isValid(i-1,j) && chessBoard[i-1][j] == 'O') 
                        || (isValid(i,j-1) && chessBoard[i][j-1] == 'O')
                        || (isValid(i-1,j-1) && chessBoard[i-1][j-1] == 'O') ) )
                        chessBoard[i][j] = 'X';

            // REMOVING ALL POSITIONS OF KING MARKED ON CHESS BOARD EXCEPT @ (0,0)
            for(int i = 0 ; i < 8 ; i++) 
                for(int j = 0 ; j < 8 ; j++) 
                    if((i != 0 || j != 0) && chessBoard[i][j] == 'O')
                        chessBoard[i][j] = '.';

            // displaying chessboard
            for(int i = 0 ; i < 8 ; i++) {
                for(int j = 0 ; j < 8 ; j++) 
                    System.out.print(chessBoard[i][j]);
                System.out.println();
            }
        }
        scn.close();
    }

    public static boolean isValid(int i, int j) {
        if( i >= 0 && j >= 0 && i < 8 && j < 8)
            return true;
        else
            return false;
    }
}