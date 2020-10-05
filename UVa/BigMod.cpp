#include <iostream>

using namespace std;
int64_t binexponential(int64_t b, int64_t p, int64_t m) {
    // BASE CONDITIONS
    if(p == 0) return 1 % m;
    if(p == 1) return b % m;

    int64_t asf = binexponential(b, p / 2, m);
    if(p & 1 > 0)   // CHECKING FOR ODD POWER
        return (asf * asf * (b % m)) % m;
    else 
        return (asf *  asf) % m;
}

int 
main(int argc, char* argv[]) {
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int64_t b, p, m, r ;
    string strbuf;

    while (cin >> b) {
        cin >> p >> m;
        getline(cin, strbuf);
        r = binexponential(b, p, m);
        cout << r << "\n";
    }

    return 0;
}