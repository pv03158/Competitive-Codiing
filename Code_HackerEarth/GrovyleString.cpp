#include <iostream>
#include <algorithm>

using namespace std;
int
main(int argc, char* argv[]) {
    int t;
    cin >> t;
    while(t --) {
        string str;
        cin >> str;

        // FINDING OVERALL SIZE OF STRING
        int n = str.length();
        // ARRANGING ELEMENTS IN SORTED ORDER
        sort(str.rbegin(), str.rend());
        // ARRANGING HEAVIEST ELEMENTS CLOSER TO THE MID
        string ans(n, ' ');
        int midpos =  (n >> 1);
        ans[midpos] = str[0];

        for(int idx = 1 ; idx <= midpos ; idx ++) {
            ans[midpos + idx] = str[2*idx - 1];
            ans[midpos - idx] = str[2*idx];
        }

        cout << ans << endl;
    }
}