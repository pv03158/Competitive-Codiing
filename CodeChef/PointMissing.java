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
            Pair<Integer, Integer>[] coordinates = new Pair[4*n - 1];
            // taking input of coordinates
            for(int idx = 0 ; idx < coordinates.length ; idx ++)
                coordinates[idx] = new Pair(scn.nextInt(), scn.nextInt());

            // processing output
            HashMap<Integer, Integer> xcounter = new HashMap<>();
            HashMap<Integer, Integer> ycounter = new HashMap<>();
            for(int idx = 0 ; idx < coordinates.length ; idx++) {
                Pair<Integer, Integer> tmp = coordinates[idx];
                if(xcounter.containsKey(tmp.getX()))
                    xcounter.put(tmp.getX(), xcounter.get(tmp.getX()) + 1);
                else  
                    xcounter.put(tmp.getX() , 1);

                if(ycounter.containsKey(tmp.getY()))
                    ycounter.put(tmp.getY(), ycounter.get(tmp.getY()) + 1 );
                else
                    ycounter.put(tmp.getY(), 1);
            }

            // showing output
            int x = 0;
            for(int key : xcounter.keySet())
                if( xcounter.get(key) % 2 != 0 )
                    x = key;

            int y = 0;
            for(int key : ycounter.keySet())
                if( ycounter.get(key) % 2 != 0 )
                    y = key;

            System.out.println(x + " " + y);
        }
    }
}