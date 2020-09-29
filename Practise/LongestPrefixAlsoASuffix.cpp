#include <iostream>
#include <vector>

using namespace std;
int
main(int argc, char* argv[]) {
    string text;
    cin >> text ;

    // FINDING PREFIX FUNCTION
    int n = text.length();
    vector<int> prefix(n);
    prefix[0] = 0;

    int i = 0, j = 1;
    while(j < n) {
        if(text.at(i) == text.at(j)) {
            prefix[j] = i + 1;
            i += 1;
            j += 1;
        }
        else if(i > 0 && text.at(i) != text.at(j))
            i = prefix[i - 1];      // FINDING THE LONGEST PREFIX IN THE PREVIOUSLY MATCHED PATTERB
                                    // TO AVOID BRUTEFORCE AND USE PRECALCULATED VALUES
        else {
            prefix[j] = 0;
            j += 1;
        }
    }

    // DISPLAYING THE LONGEST PREFIX WHICH IS ALSO A SUFFIX
    int maxlength = 0;
    for(int val : prefix)
        maxlength = max(maxlength, val);

    cout << text.substr(0, maxlength);
}