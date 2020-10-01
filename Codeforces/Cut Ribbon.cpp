#include <iostream>

using namespace std;
int dfs(int n , int a, int b, int c, int dp[]) {
    if(n < 0) return -1;
    if(n == 0) return 0;

    if(dp[n] != 0)
        return dp[n];

    int counter = -1;
    counter = max(counter , dfs(n - a, a,b,c,dp));
    counter = max(counter , dfs(n - b, a,b,c,dp));
    counter = max(counter , dfs(n - c, a,b,c,dp));
    return dp[n] = (counter == -1) ? counter : counter + 1;
}

int
main(int argc, char* argv[]) {
    int n, a, b, c;
    cin >> n >> a >> b >> c;

    int dp[n + 1] = { 0 };
    cout << dfs(n, a, b , c, dp) << endl;
    return 0;
}