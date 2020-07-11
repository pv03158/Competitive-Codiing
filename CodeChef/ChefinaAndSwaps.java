import java.util.*;

public class ChefinaAndSwaps {
    public static void main(String argsp[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {

            // taking input
            int n = scn.nextInt();
            Integer a[] = new Integer[n];
            Integer b[] = new Integer[n];
            for(int idx = 0 ; idx < n ; idx++) 
                a[idx] = scn.nextInt();

            for(int idx = 0 ; idx < n ; idx++)
                b[idx] = scn.nextInt();

            // processing output
            HashMap<Integer, Integer> freqcounter = new HashMap<>();
            for(int idx = 0 ; idx < n ; idx++) {
                if(freqcounter.containsKey(a[idx]))
                    freqcounter.put(a[idx], freqcounter.get(a[idx]) + 1 );
                else
                    freqcounter.put( a[idx], 1 );
            }
            for(int idx = 0 ; idx < n ; idx++) {
                if(freqcounter.containsKey(b[idx]))
                    freqcounter.put(b[idx], freqcounter.get(b[idx]) + 1 );
                else
                    freqcounter.put( b[idx], 1 );
            }

            long mincost = 0;
            boolean flag = false;
            Set<Integer> keySet = freqcounter.keySet();
            Integer swappedArr[] = new Integer[n];
            int iter = 0;
            for( Integer key : keySet) {
                int frequency = freqcounter.get(key);
                if(frequency % 2 != 0) {
                    mincost = -1;
                    flag = true;
                    break;
                }
                
                int loopcounter = frequency / 2;
                while(loopcounter-- > 0)
                    swappedArr[iter++] = key;
            }

            if( !flag ) {
                Arrays.sort(swappedArr, Collections.reverseOrder());
                Arrays.sort(a, Collections.reverseOrder());
                Arrays.sort(b, Collections.reverseOrder());
                PriorityQueue<Integer> replacedVals = new PriorityQueue<>();

                for(int idx = 0 ; idx < n ; idx++)
                    if(swappedArr[idx] != a[idx])
                        replacedVals.add(a[idx]);

                for(int idx = 0 ; idx < n ; idx++)
                    if(swappedArr[idx] != b[idx])
                        replacedVals.add(b[idx]);

                int iterator = replacedVals.size();
                mincost = iterator * Math.min(a[n-1],b[n-1]);
            }

            // displaying output
            System.out.println(mincost);
        }
        scn.close();
    }
}