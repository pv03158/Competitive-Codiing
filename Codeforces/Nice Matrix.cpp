#include <iostream>
#include <cmath>

using namespace std;
int
main(int argc, char* argv[]) {
    int t;
    cin >> t;
    while(t--) {
        int m, n;
        cin >> m >> n;
        int64_t mat[m][n];

        for(int i = 0 ; i < m ; i++)
            for(int j = 0; j < n ; j++)
                cin >> mat[i][j];

        // PROCESSING OUTPUT
        int64_t cost = 0;
        for(int i = 0 ; i < ceil(m/2.0f) ; i++) {
            for(int j = 0 ; j < ceil(n/2.0f) ; j++) {
                int64_t a = mat[i][j], b = mat[m - i - 1][j], c = mat[i][n - j - 1];
                int64_t d = mat[m - i - 1][n - j - 1];
                
                int64_t avg = (a + b + c + d) / 4;
                cost += abs(mat[i][j] - avg);
                mat[i][j] = avg;
                cost += abs(avg - mat[m - i - 1][j]);
                mat[m - i - 1][j] = avg;
                cost += abs(avg - mat[m - i - 1][n - j - 1]);
                mat[m - i - 1][n - j - 1] = avg;
                cost += abs(avg - mat[i][n - j - 1]);
                mat[i][n - j - 1] = avg;
            }
        }
        // DISPLAYING OUTPUT
        cout << cost << endl;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++)
                cout << mat[i][j] << " ";
            cout << endl;
        }
    }
    return 0;
}