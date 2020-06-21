import java.util.*;

public class PrimeFibonacci {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int idx = n1 ; idx <= n2 ; idx++ ) 
            if( isPrime(idx) )
                arr1.add(idx);

        ArrayList<Integer> arr2 = new ArrayList<>();
        for( int i = 0 ; i < arr1.size() ; i++ )
            for( int j = 0 ; j < arr1.size() ; j++ )
                if( i != j ) 
                    arr2.add( Integer.valueOf(String.valueOf(arr1.get(i)) + String.valueOf(arr1.get(j))) );
        
        HashMap<Integer,Integer> arr3 = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int idx = 0 ; idx < arr2.size() ; idx ++) {
            int val = arr2.get(idx);
            if( isPrime(val) ) {
                min = Math.min(min,val);
                max = Math.max(max,val);
                arr3.put(val, 0 );
            }
        }
        int size = arr3.size();
        long fnum = min;
        long snum = max;
        for( int iter = 1 ; iter < size ; iter++) {
            long tmp = fnum + snum;
            fnum = snum;
            snum = tmp;
        }
        System.out.println(fnum);
        // for(int val : arr2)
        //     System.out.println(val);

    }

    public static boolean isPrime(int num) {
        if(num == 1 || num == 0)
            return false;

        for( int idx = 2 ; idx*idx <= num ; idx++ ) 
            if( num % idx == 0 )
                return false;
        return true;
    }
}