#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
    int n ;
    cin >> n ;
    int arr[n];
    for(int idx = 0 ; idx < n ; idx ++)
        cin >> arr[idx];

    int i = 0, j = 1;
    int counter = 1;
    while(j < n) {
        if(arr[j] < arr[j - 1])
            i = j;
        counter = max(counter , j - i + 1);
        j += 1;
    }

    cout << counter ;
    return 0;
}