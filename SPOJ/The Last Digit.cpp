#include <iostream>

using namespace std;
int 
main(int argc, char* argv[]) {
    // OPTIMISING IO OPERATIONS
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // TAKING INPUT FROM CONSOLE
    int64_t t, a, b;
    cin >> t;
    while(t--) {
        cin >> a >> b;

        // USING BINARY EXPONENTIAL ALGORITHM TO FIND THE POWER
        int res = 1;
        while(b > 0) {
            // FOR ODD POWERS
            if( b & 1 > 0 )
                res = (res * a) % 10;
            a = (a * a) % 10;       
            b = b >> 1;
        }

        cout << res << "\n"; 
    }
    return 0;
}