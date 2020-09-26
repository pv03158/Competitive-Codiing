#include <iostream>
#include <random>
#include <chrono>

using namespace std;
int
main(int argc, char* argv[]) {
    mt19937_64 random_number_generator(chrono::steady_clock::now().time_since_epoch().count());
    cout << random_number_generator();
}