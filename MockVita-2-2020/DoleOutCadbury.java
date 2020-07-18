import java.util.*;

public class DoleOutCadbury {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        // taking input from user
        int minLength = scn.nextInt();
        int maxLength = scn.nextInt();
        int minWidth = scn.nextInt();
        int maxWidth = scn.nextInt();

        // processing output
        int counter = 0;
        for(int length = minLength ; length <= maxLength ; length++) 
            for(int width = minWidth ; width <= maxWidth ; width++) 
                counter += countOfChildsAmongChocolateDistributed(new Pair(length,width));

        // displaying output
        System.out.println(counter);
        scn.close();
    }

    public static int countOfChildsAmongChocolateDistributed(Pair dimensions) {
        int length = dimensions.getValues()[0];
        int width = dimensions.getValues()[1];
        
        int counter = 0;
        while(length > 0 && width > 0) {
            // making width always larger than length
            if(length < width) {
                int tmp = length;
                length = width;
                width = tmp;
            }
            length = length - width;
            counter += 1;
        }
        return counter;
    }

    public static class Pair {
        int val1;
        int val2;

        public Pair(int i, int j) {
            val1 = i;
            val2 = j;
        }

        public int[] getValues() {
            int tmp[] = new int[]{ val1, val2 };
            return tmp;
        }
    }
}