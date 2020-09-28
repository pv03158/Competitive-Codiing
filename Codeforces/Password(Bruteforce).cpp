#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
    string str;
    cin >> str;

    int length = 1;
    string t;
    while( length < str.length() - 1 ) {
        string prefix = str.substr(0 , length);
        string suffix = str.substr(str.length() - length , length);
        
        if(prefix == suffix) {
            // CHECKING FOR IN BETWEEN PRESENCE
            string substr = str.substr(1, str.length() - 2);
            if(substr.find(prefix) != string::npos)
                t = prefix;
        }

        length += 1;
    }

    if(t.length() == 0)
        cout << "Just a legend";
    else 
        cout << t << endl;
}