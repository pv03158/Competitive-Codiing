#include <iostream>
#include <vector>

using namespace std;
int
main(int argc , char* argv[]) {
    string text;
    cin >> text;

    // GENERATING PREFIX SUM VECTOR OF STRING HASH
    const int base = 107;
    const int mod = 1e9 + 7;
    // HASHING FORMULA - (a + b*p1 + c*p2 + ...) % mod
    vector<int64_t> p(text.length());
    p[0] = 1;
    for(int idx = 1 ; idx < p.size() ; idx++)
        p[idx] = (p[idx - 1] * base) % mod;

    vector<int64_t> thash(text.length() + 1, 0);
    for(int idx = 0 ; idx < text.length() ; idx++)
        thash[idx + 1] = (thash[idx] + (text.at(idx) - 'a' + 1) * p[idx]) % mod;

    string ans = "Just a legend";
    // CHECKING FOR SIMILARITY IN PREFIX AND SUFFIX
    for(int len = text.length() - 2 ; len >= 1 ; len -- ) {
        int64_t phash = thash[len];
        int64_t shash = (thash[text.length()] + mod - thash[text.length() - len]) % mod;

        if( (phash * p[text.length() - len]) % mod == shash ) {
            // HERE WE GOT MATCHED PREFIX AND SUFFIX
            // USING PHASH ON ROLLING IT OVER THE IN BETWEEN STRING 
            for(int idx = 2 ; idx + len <  thash.size()  ; idx++) {
                int64_t chash = (thash[ idx + len - 1] + mod - thash[ idx - 1 ]) % mod;
                if( chash == (phash * p[idx - 1]) % mod) {
                    ans = text.substr(0, len);
                    cout << ans;
                    return 0;                
                }
            }
        }
    }

    cout << ans;
    return 0;
}