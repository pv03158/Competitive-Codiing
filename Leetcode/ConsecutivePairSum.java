class Solution {
    public int consecutiveNumbersSum(int n) {
        // MANAGING CORNER CASES
        if(n == 1)
            return 1;
        
        // HENCE CONSECUTIVE NUMBER STARTING WITH A AND HAVING K + 1
        // CONSECUTIVE TERMS, THEN THE RELATION BETWEEN THEM BE
        // N = (K+1)(A + K/2);
        int a = n, k = 0;
        int counter = 0;    // COUNTER HOLDS NUMBER OF SUCH PAIRS FOUND
        
        while(a > 1) {
            int divident = 2 * n - k * ( k + 1 );
            int divisor = 2 * ( k + 1 );
            
            // HENCE, A ALWAYS WILL BE AN INTEGER, SO CHECKING
            // IF DIVIDENT VALUE AND DIVISOR VALUE HAVE A COMMON
            // FACTOR
            if(divident % divisor == 0)
                counter += 1;
            
            a = divident / divisor;
            k += 1;
        }
        
        return counter;
    }
}