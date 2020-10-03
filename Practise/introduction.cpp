#include <iostream>
#include <string>
#include <sstream>

using namespace std;
int
main(int argc, char* argv[]) {
    string num;
    cin >> num;

    cout << stoi(num) + 1;
    int val = 4*6;
    ostringstream sout;
    sout << val;

    cout << sout.str();
}