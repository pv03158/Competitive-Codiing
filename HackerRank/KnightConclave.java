import java.util.*;

public class KnightConclave {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int k = scn.nextInt();
        int config[][] =  new int[r][c];
        getKnightConclave(0,0,k,config,new boolean[r][c]);
        
    }

    public static void getKnightConclave(int r_idx,int c_idx,int k,int chess[][],boolean dangerPos[][]) {
        // base condition
        if(k == 0) {
            for(int i=0;i<chess.length;i++) {
                for(int j=0;j<chess[0].length;j++) {
                    System.out.print(chess[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        if(r_idx == chess.length-1 &&  c_idx == chess[0].length-1 && k == 1) {   
            if( !dangerPos[r_idx][c_idx] ) {
                chess[r_idx][c_idx] = 1;
                for(int i=0;i<chess.length;i++) {
                    for(int j=0;j<chess[0].length;j++) {
                        System.out.print(chess[i][j]+" ");
                    }
                    System.out.println();
                }
                chess[r_idx][c_idx] = 0;
                return;
            }
            else 
                return;
        }
            // danger positions marked
            // System.out.println("Danger pos");
            // for(int i=0;i<chess.length;i++) {
            //     for(int j=0;j<chess[0].length;j++) {
            //         System.out.print(dangerPos[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            
            // placing other knights
        for(int i=r_idx; i < chess.length;i++) {
            for(int j=c_idx; j < chess[0].length;j++) {
                System.out.println(i+":"+j);
                if( !dangerPos[i][j] && chess[i][j] == 0 ){
                    chess[i][j] = 1;
                    
                    // marking danger positions
                    if(r_idx-2 > 0 && r_idx-2 < chess.length && c_idx+1 > 0 && c_idx+1 < chess[0].length) dangerPos[r_idx-2][c_idx+1] = true;
                    if(r_idx-1 > 0 && r_idx-1 < chess.length && c_idx+2 > 0 && c_idx+2 < chess[0].length) dangerPos[r_idx-1][c_idx+2] = true;
                    if(r_idx+1 > 0 && r_idx+1 < chess.length && c_idx+2 > 0 && c_idx+2 < chess[0].length) dangerPos[r_idx+1][c_idx+2] = true;
                    if(r_idx+2 > 0 && r_idx+2 < chess.length && c_idx+1 > 0 && c_idx+1 < chess[0].length) dangerPos[r_idx+2][c_idx+1] = true;
                    if(r_idx+2 > 0 && r_idx+2 < chess.length && c_idx-1 > 0 && c_idx-1 < chess[0].length) dangerPos[r_idx+2][c_idx-1] = true;
                    if(r_idx+1 > 0 && r_idx+1 < chess.length && c_idx-2 > 0 && c_idx-2 < chess[0].length) dangerPos[r_idx+1][c_idx-2] = true;
                    if(r_idx-1 > 0 && r_idx-1 < chess.length && c_idx-2 > 0 && c_idx-2 < chess[0].length) dangerPos[r_idx-1][c_idx-2] = true;
                    if(r_idx-2 > 0 && r_idx-2 < chess.length && c_idx-1 > 0 && c_idx-1 < chess[0].length) dangerPos[r_idx-2][c_idx-1] = true;

                    getKnightConclave(i,j+1,k-1,chess,dangerPos);
                    chess[r_idx][c_idx] = 0;
                    if(r_idx-2 > 0 && r_idx-2 < chess.length && c_idx+1 > 0 && c_idx+1 < chess[0].length) dangerPos[r_idx-2][c_idx+1] = false;
                    if(r_idx-1 > 0 && r_idx-1 < chess.length && c_idx+2 > 0 && c_idx+2 < chess[0].length) dangerPos[r_idx-1][c_idx+2] = false;
                    if(r_idx+1 > 0 && r_idx+1 < chess.length && c_idx+2 > 0 && c_idx+2 < chess[0].length) dangerPos[r_idx+1][c_idx+2] = false;
                    if(r_idx+2 > 0 && r_idx+2 < chess.length && c_idx+1 > 0 && c_idx+1 < chess[0].length) dangerPos[r_idx+2][c_idx+1] = false;
                    if(r_idx+2 > 0 && r_idx+2 < chess.length && c_idx-1 > 0 && c_idx-1 < chess[0].length) dangerPos[r_idx+2][c_idx-1] = false;
                    if(r_idx+1 > 0 && r_idx+1 < chess.length && c_idx-2 > 0 && c_idx-2 < chess[0].length) dangerPos[r_idx+1][c_idx-2] = false;
                    if(r_idx-1 > 0 && r_idx-1 < chess.length && c_idx-2 > 0 && c_idx-2 < chess[0].length) dangerPos[r_idx-1][c_idx-2] = false;
                    if(r_idx-2 > 0 && r_idx-2 < chess.length && c_idx-1 > 0 && c_idx-1 < chess[0].length) dangerPos[r_idx-2][c_idx-1] = false;
                }
            }
        }
    }
}