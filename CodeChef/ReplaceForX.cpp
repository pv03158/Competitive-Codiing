// REPLACE FOR X - https://www.codechef.com/OCT20B/problems/REPLESX
#include <iostream>
#include <algorithm>

using namespace std;
int main(int argc, char* argv[]) {
    // OPTIMISING IO OPERATIONS FROM STDIO
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    // ATTACHING IO FILES WITH STDIO
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    // TAKING INPUT FROM CONSOLE
    int t, n, x, p, k, maxm = 1e6;
    int arr[maxm];
    cin >> t;
    while(t--) {
        // WORKING ON EACH TEST CASE
        cin >> n >> x >> p >> k;
        for(int idx = 0 ; idx < n ; idx++)
            cin >> arr[idx];

        // SORTING ARRAY IN ASCENDING ORDER
        sort(arr, arr + n);
        p -= 1;
        k -= 1;

        int cost = 0;
        // IF P <= K
        if(p <= k) {
            if(p < k && arr[p] < x) 
                cost = -1;
            else if(arr[p] == x)
                cost = 0;
            else {
                while(arr[p] != x) {
                    int ub = -1;
                    for(int idx = 0 ; idx < p ; idx++)
                        if(arr[idx] == x)
                            ub = idx;

                    if(ub != -1) {
                        cost += abs(p - ub);
                        break;
                    }
                    else {
                        arr[k] = x;
                        cost += 1;
                        sort(arr, arr + n);
                    }
                }
            }
        }
        // IF P > K
        else {
            if(arr[p] > x)
                cost = -1;
            else if(arr[p] == x)
                cost = 0;
            else {
                while(arr[p] != x) {
                    int lb = -1;
                    for(int idx = p + 1; idx < n ; idx++)
                        if(arr[idx] == x) {
                            lb = idx;
                            break;
                        }

                    if(lb != -1) {
                        cost += abs(lb - p);
                        break;
                    }
                    else {
                        arr[k] = x;
                        cost += 1;
                        sort(arr, arr + n);
                    }
                }
            }
        }

        // DISPLAYING OUTPUT
        cout << cost << endl;
    }
    return 0;
}