#include <iostream>

using namespace std;
int
binomialcoeff(int n, int r) {
    double res = 1;
    for(int i = 0; i < r ; i++) 
        res *= (double)(n-i) / (double)(r-i) ;
    return (int)(res + 0.5f);
}

int 
main(int argc, char* argv[]) {
    // OPTIMISING IO FROM STDIo
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // TAKING INPUT FROM CONSOLE
    int t, n, k;
    cin >> t;
    while(t--) {
        // EVALUATING EACH TEST CASE
        int res = 0;
        cin >> n >> k;
        for(int i = 1 ; i <= n; i++) 
            for(int j = 1 ; j <= n ; j++) 
                res += binomialcoeff(abs(j - i) + k, k);

        cout << res << endl; 
    }
    return 0;
}