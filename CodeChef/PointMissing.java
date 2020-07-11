import java.util.*;

public class PointMissing {
    
    public static class Pair<K, V> {
        public K x;
        public V y;
        public Pair(K x , V y) {
            this.x = x;
            this.y = y;
        }
        public K getX() {
            return x;
        }
        public V getY() {
            return y;
        }
    }
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-- > 0 ) {
            int n = scn.nextInt();

            // taking input & processing output
            HashMap<Integer, Integer> xcounter = new HashMap<>();
            HashMap<Integer, Integer> ycounter = new HashMap<>();
            int count = 4*n - 1;
            for(int idx = 0 ; idx < count ; idx++) {
                int x = scn.nextInt();
                int y = scn.nextInt();

                if(xcounter.containsKey(x))
                    xcounter.put(x, xcounter.get(x) + 1);
                else  
                    xcounter.put(x , 1);

                if(ycounter.containsKey(y))
                    ycounter.put(y, ycounter.get(y) + 1 );
                else
                    ycounter.put(y, 1);
            }

            // showing output
            int x = 0;
            Set<Integer> keys = xcounter.keySet();
            for(int key : keys) {
                if( xcounter.get(key) % 2 != 0 ) {
                    x = key;
                    break;
                }
            }

            int y = 0;
            keys = ycounter.keySet();
            for(int key : keys) {
                if( ycounter.get(key) % 2 != 0 ) {
                    y = key;
                    break;
                }
            }

            System.out.println(x + " " + y);
        }
    }
}