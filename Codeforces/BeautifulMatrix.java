import java.util.*;

public class BeautifulMatrix {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        
        //taking input from user
        for(int row = 0 ; row < 5 ; row++) {
            for(int col = 0 ; col < 5 ; col++) {
                int val = scn.nextInt();
                if(val == 1) 
                    System.out.println(Math.abs(2 - row) + Math.abs(2 - col));
            }
        }
    }
}