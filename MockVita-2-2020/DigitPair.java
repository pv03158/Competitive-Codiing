import java.util.*;

public class DigitPair {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        // taking input from cli
        int n = scn.nextInt();
        scn.nextLine();
        String str = scn.nextLine();
        String nums[] = str.split(" ");

        // processing output
        String bitScore[] = new String[n];
        for(int idx = 0 ; idx < n ; idx++)
            bitScore[idx] = calcBitScore(nums[idx]);

        int pairCounter = 0;
        HashMap<Character, Integer> usedBitsFrequency = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            for(int j = i+1 ; j < n ; j++) {
                int frequency = 0;
                if( usedBitsFrequency.containsKey(bitScore[i].charAt(0)) )
                    frequency = usedBitsFrequency.get(bitScore[i].charAt(0));
                if( i != j && bitScore[i].charAt(0) == bitScore[j].charAt(0) && frequency < 2 && isBothIdxAreEvenOrOdd(i,j)) {
                    pairCounter += 1;
                    usedBitsFrequency.put( bitScore[i].charAt(0),frequency + 1 );
                }
            }
        }

        // displaying output
        System.out.println(pairCounter);
        scn.close();
    }

    public static String calcBitScore( String num ) {
        int length = 3;
        int bits[] = new int[length]; 
        int number = Integer.valueOf(num);
        int counter = 0;
        while(counter < 3) {
            bits[counter] = number % 10;
            number /= 10;
            counter += 1;
        }

        int largestBit, smallestBit;
        largestBit = Math.max( bits[0], Math.max(bits[1],bits[2]) );
        smallestBit = Math.min( bits[0], Math.min(bits[1], bits[2]) );
        String bitScore = Integer.toString(largestBit * 11 + smallestBit * 7);
        if( bitScore.length() == 3 )
            bitScore = bitScore.substring(1);

        return bitScore;
    }

    public static boolean isBothIdxAreEvenOrOdd(int i, int j) {
        if(i%2 == j%2)
            return true;
        else
            return false;
    }

}