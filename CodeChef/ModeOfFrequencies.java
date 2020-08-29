import java.util.HashMap;
import java.util.Scanner;

public class ModeOfFrequencies {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            int maxFreq = 0;
            for(int idx = 0 ; idx < n ; idx++) {
                int val = scn.nextInt();
                if(hm.containsKey(val))
                    hm.put(val, hm.get(val) + 1);
                else
                    hm.put(val, 1);

                maxFreq = Math.max(maxFreq, hm.get(val));
            }

            int minvalue = (int) 10e8;
            for( int key : hm.keySet() ) {
                if(hm.get(key) == maxFreq)
                    minvalue = Math.min(minvalue, key);
            }

            System.out.println(minvalue);
        }
    }
}