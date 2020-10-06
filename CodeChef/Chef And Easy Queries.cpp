#include <iostream>

using namespace std;
int 
main(int argc, char* argv[]) {
    // OPTIMISING IO OPERATIONS
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // TAKING INPUT FROM CONSOLE
    int t;
    cin >> t;
    while(t--) {
        // PROCESSING OUTPUT
        int64_t carry = 0, ele, n, k;
        cin >> n >> k;

        bool flag = false;
        for(int iter = 0 ; iter < n ; iter ++) {
            cin >> ele;
            if(!flag && carry + ele - k < 0) {
                cout << iter + 1 << endl;
                flag = true;
            }
            else 
                carry = carry + ele - k;
        }

        // DISPLAYING OUTPUT
        if( !flag )
        cout << carry / k + n + 1 << endl;
    }
    return 0;
}