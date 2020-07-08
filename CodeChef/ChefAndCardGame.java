import java.util.*;

public class ChefAndCardGame {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0 ) {
            // taking input
            int n = scn.nextInt();
            int cardChefVal[] = new int[n];
            int cardMortyVal[] = new int[n];
            for( int idx = 0 ; idx < n ; idx ++) {
                cardChefVal[idx] = scn.nextInt();
                cardMortyVal[idx] = scn.nextInt();
            }

            int chefscore = 0;
            int mortyscore = 0;
            // processing output
            for(int idx = 0 ; idx < n ; idx++) {
                int chefpoint = pointCalc(cardChefVal[idx]);
                int mortypoint = pointCalc(cardMortyVal[idx]);
                if(chefpoint > mortypoint)
                    chefscore += 1;
                else if(chefpoint < mortypoint)
                    mortyscore += 1;
                else {
                    chefscore += 1;
                    mortyscore += 1;
                }
            }
            // showing output
            if(chefscore > mortyscore)
                System.out.println(0 + " " + chefscore);
            else if(chefscore < mortyscore)
                System.out.println(1 + " " + mortyscore);
            else
                System.out.println(2 + " " + chefscore);
        }
        scn.close();
    }

    public static int pointCalc(int num) {
        int length = Integer.toString(num).length();
        int counter = 0;

        while(length-- > 0) {
            int bit = num % 10;
            num /= 10;
            counter += bit;
        }
        
        return counter;
    }
}