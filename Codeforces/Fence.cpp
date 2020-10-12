#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
    int64_t t, a, b, c, d;
    cin >> t;
    while(t--) {
        cin >> a >> b >> c;
        int64_t d = (a + b + c) / 3;

        cout << d << endl;
    }
    return 0;
}