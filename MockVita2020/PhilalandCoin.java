import java.util.*;

public class PhilalandCoin {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int maxdenomination = scn.nextInt();
            
            // boundary values management
            int bitcounter = 1;
            while( Math.pow(2,bitcounter) <= maxdenomination )
                bitcounter ++;

            System.out.println(Math.min(bitcounter, maxdenomination));
        }
    }
}