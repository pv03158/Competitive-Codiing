#include <iostream>

using namespace std;
int
main(int argc, char* argv[]) {
    int64_t den;
    cin >> den;

    // CHECKING NUMBER OF BILLS OF 100 REQUIRED TO DESOLVE DENOMINATION
    int counter = 0;
    counter += den / 100;
    den %= 100;
    
    // CHECKING NUMBER OF BILLS OF 20 REQUIRED TO DESOLVE DENOMINATION
    counter += den /20;
    den %= 20;

    // CHECKING NUMBER OF BILLS OF 10 REQUIRED TO DESOLVE DENOMINATION
    counter += den /10;
    den %= 10;

    // CHECKING NUMBER OF BILLS OF 5 REQUIRED TO DESOLVE DENOMINATION
    counter += den / 5;
    den %= 5;

    // CHECKING NUMBER OF BILLS OF 1 REQUIRED TO DESOLVE DENOMINATION
    counter += den / 1;
    cout << counter;
}