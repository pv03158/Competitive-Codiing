#include <iostream>
#include <string>

#define BigInteger signed long long int

using namespace std;
int
main(int argc, char* argv[]) {
    BigInteger length;
    while( scanf("%lld", &length) != EOF ) {
        // TAKING INPUT FROM STDIN
        BigInteger idx = 0;
        string needle, haystack;
        cin >> needle >> haystack;

        // PROCESSING OUTPUT
        hash<string> compute_hash;
        BigInteger needle_hash = compute_hash(needle);
        for(idx = 0 ; idx <= (BigInteger) haystack.length() - length ; idx++) {
            string substr = haystack.substr(idx, length);
            if( compute_hash(substr) == needle_hash )
                cout << idx << endl;
        }
        if(idx == 0)
            cout << endl;
    }
}