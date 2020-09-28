#include <iostream>

using namespace std;
int 
main(int argc, char* argv[]) {
    string str;
    cin >> str;

    int length = str.length();
    const int base = 2;
    const int64_t mod = 1e8 + 7;
    int64_t p[ length ];
    // GENERATING MULTIPLIER
    p[0] = 1;
    for(int idx = 1 ; idx < length ; idx++) {
        p[idx] = (p[idx - 1] * base) % mod;
        cout << p[idx] << endl;
    }
    // GENERATING HASHCODES
    int hashcode[length];
    for(int idx = 0 ; idx < length ; idx++) {
        hashcode[idx] = str.at(idx) - 'a' + 1;
        cout << hashcode[idx] << endl;
    }
    
    // FINDING PREFIX AND SUFFIX
    int i = 0, j = length - 1, prefix = 0, suffix = 0;
    for(int iter = 0 ; iter < length - 1 ; iter++) {
        int64_t prefix = prefix + hashcode[i] * p[iter];
        int64_t suffix = suffix * base + hashcode[j];

        cout << prefix << "\t" << suffix << endl;
        if(prefix == suffix)
            cout << i << " , " << j << endl;
    }

}