#include <iostream>
#include <vector>

using namespace std;
int
main(int argc, char* argv[]) {
    string test, pattern;
    cin >> test >> pattern;

    // N -> LENGTH OF TEST STRING, M -> LENGTH OF PATTERN
    int n = test.length(), m = pattern.length();
    // FINDING THE PREFIX FUNCTION FOR THE PATTERN
    vector<int> prefix(m);
    prefix[0] = 0;
    // I -> PREFIX, J -> SUFFIX
    int i = 0, j = 1;
    while( j < m ) {
        if(pattern[i] == pattern[j]) {
            prefix[j] = i + 1;
            i ++ ;
            j ++ ;
        }
        else if(i > 0)
            i = prefix[i - 1];
        else 
            prefix[j ++ ] = 0;
    }

    // CHECKING THE NUMBER OF COUNTS OF PATTERN IN TEST STRING
    // USING ? AS DONT CARE VALUES
    // I -> TEST STRING & J -> PATTERN STRING
    i = 0, j = 0;
    int counter = 0;
    while( i < n ) {
        if( test[i] == '?' || test[i] == pattern[j] ) {
            i += 1;
            j += 1;
        }
        else if( j > 0) 
            j = prefix[j - 1];
        else 
            i += 1;

        // EXECUTES WHEN A PATTERN IS MATCHED IN STRING
        if( j == m ) {
            counter += 1;
            j = prefix[j - 1];
        }
    }

    // DISPLAYING THE ANSWER
    cout << counter << endl;
}