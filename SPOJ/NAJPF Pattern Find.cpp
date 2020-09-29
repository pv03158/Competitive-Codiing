#include <iostream>
#include <vector>

using namespace std;
int
main(int argc, char* argv[]) {
    int t;
    cin >> t;

    while(t -- ) {
        string test, pattern;
        cin >> test >> pattern;

        // USING KMP ALGORITHM TO FIND THE PATTERN IN TEST STRING
        // CREATING PREFIX FUNCTION (ARRAY) FOR PATTERN
        int n = test.length(), m = pattern.length();
        vector<int> prefix(m);
        prefix[0] = 0;
        int i = 0, j = 1;   // I -> PREFIX, J -> SUFFIX
        while( j < m ) {
            if( pattern[i] == pattern[j] ) {
                prefix[j] = i + 1;
                i += 1;
                j += 1;
            }
            else if( i > 0)
                i = prefix[i - 1];
            else 
                prefix[j ++ ] = 0;
        }

        // FINDING FOR THE PATTERN IN TEST STRING
        // I -> TEST STRING, J -> PATTERN STRING
        i = 0, j = 0;
        int counter = 0;
        vector<int> pos;
        while( i < n) {
            if(test[i] == pattern[j]) {
                i += 1;
                j += 1;
            }
            else if( j > 0)     // WHEN J IS NOT ON 0, IN PATTERN STRING, PUTTING IT THE
                                // PLACE WHERE PREFIX IS ALSO A SUFFIX
                j = prefix[j - 1];
            else        // WHEN J IS AT 0 IDX IN PATTERN STRING
                i += 1;

            // CHECKING WHETHER THE PATTERN IS IN TEST STRING
            if( j == m ) {
                counter += 1;
                pos.push_back( i - m + 1);
                j = prefix[j - 1];
            }
        }

        if(counter)
            cout << counter << endl;
        else
            cout << "Not Found" << endl;
        for(int val : pos)
            cout << val << " ";
        cout << endl << endl;
    }
}