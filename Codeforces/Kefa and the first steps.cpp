#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
    // TAKING INPUT FROM CONSOLE
    int n ;
    cin >> n ;
    int arr[n];
    for(int idx = 0 ; idx < n ; idx ++)
        cin >> arr[idx];

    // USING TWO POINTER APPROACH 
    int i = 0, j = 1;
    int counter = 1;
    while(j < n) {
        if(arr[j] < arr[j - 1])
            i = j;
        counter = max(counter , j - i + 1);
        j += 1;
    }

    // DISPLAYING OUTPUT
    cout << counter ;
    return 0;
}