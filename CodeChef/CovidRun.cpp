#include <iostream>

using namespace std;
int 
main(int argc, char* argv[]) {
    // OPTIMISING INPUT FROM STDIN
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // TAKING INPUT FROM USER
    int t, n , k, x, y;
    cin >> t;
    // ITERATING OVER EACH CASE
    while(t--) {
        cin >> n >> k >> x >> y;
        bool status = false;
        for(int iter = 0 ; iter < n ; iter ++)
            if(( x + iter*k ) % n == y ) {
                status = true;
                break;
            }

        if(status) cout << "YES" << "\n";
        else cout << "NO" << "\n";
    }

    return 0;
}