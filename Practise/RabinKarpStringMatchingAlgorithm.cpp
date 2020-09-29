#include <iostream>
#include <vector>

using namespace std;
int
main(int argc, char* argv[]) {
    string pattern = "pap";
    string text = "papapap";

    // GENERATING VECTOR OF PRIME NUMBER
    vector<int64_t> p(max(pattern.length(), text.length()));
    p[0] = 1;
    const int base = 7;
    const int64_t mod = 1e9 + 7;
    for(int idx = 1 ; idx < p.size() ; idx++)
        p[idx] = (p[idx - 1] * base) % mod;

    // GENERATING HASHCODE FOR PATTERN
    int64_t phash = 0;
    for(int idx = 0 ; idx < pattern.length() ; idx++)
        phash = (phash + (pattern.at(idx) - 'a' + 1) * p[idx]) % mod;
    
    // GENERATING PREFIX SUM VECTOR OF TEXT HASH
    vector<int64_t> thash(text.length() + 1, 0);
    for(int idx = 0 ; idx < thash.size() - 1 ; idx++) 
        thash[idx + 1] = (thash[idx] + (text.at(idx) - 'a' + 1) * p[idx]) % mod;

    // SEARCHING FOR REQUIRED PATTERN USING ROLLING HASH FUNCTION
    for(int idx = 0 ; idx + pattern.length() < thash.size() ; idx++) {
        int64_t chash = thash[idx + pattern.length()] - thash[idx];
        if(chash == (phash * p[idx]) % mod)
            cout << idx << endl;
    }
}