#include <iostream>

using namespace std;
int64_t binpow(int64_t x, int64_t y, int64_t n) {
    if(y == 0) return 1;
    if(y == 1) return x % n;

    int64_t asf = binpow(x, y / 2, n) % n;
    // FOR ODD POWERS
    if( y&1 > 0 )
        return (asf * asf * x) % n;
    else 
        return (asf * asf)  % n;
}

int 
main(int argc, char* argv[]) {
    // OPTIMISING IO FROM STDIN
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // TAKING INPUT FROM USER
    int64_t t, x, y, n, z;
    cin >> t;

    while(t--) {
        cin >> x >> y >> n;
        z =  binpow(x, y, n);
        // DISPLAYING OUTPUT
        cout << z << endl;
    }

    return 0;
}