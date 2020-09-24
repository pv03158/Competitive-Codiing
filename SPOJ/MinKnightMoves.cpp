#include <iostream>
#include <queue>
#include <utility>
#include <cstring>

using namespace std;

int bfs(pair<int,int> src, pair<int, int> dst) {
    bool vis[8][8];
    memset(vis, 0, sizeof(vis));
    int dir[8][2] = { {-2,1}, {-2,-1}, {2,-1}, {2,1}, {-1,2}, {-1,-2}, {1,2}, {1,-2} };

    queue<pair<pair<int,int>,int>> q;       // <INDEX I, INDEX J>, LEVEL
    q.push(make_pair(src, 0));
    vis[src.first][src.second] = true;

    while( !q.empty() ) {
        pair<pair<int,int>, int> cpos = q.front();
        q.pop();
        int i = cpos.first.first;
        int j = cpos.first.second;
        int level = cpos.second;
    
        if(cpos.first == dst)
            return level;

        for(int idx = 0 ; idx < 8 ; idx++) {
            int r = i + dir[idx][0];
            int c = j + dir[idx][1];
            if( r >= 0 && c >= 0 && r < 8 && c < 8 ) {
                if( !vis[r][c] ) {
                    q.push(make_pair(make_pair(r,c), level + 1));
                    vis[r][c] = true;
                }
            }
        }
    }

    return -1;
}

int
main(int argc, char* argv[]) {
    int t;
    cin >> t;

    while( t-- ) {
        // TAKING INPUT OF SOURCE AND DESTINATION
        char ch1, ch2;
        cin >> ch1 >> ch2;
        // PARSING SRC AND DESTINATION IN TERMS OF MATRIX INDICES
        pair<int, int> src = make_pair(ch1 - 'a', ch2 - '1');
        cin >> ch1 >> ch2;
        pair<int, int> dst = make_pair(ch1 - 'a', ch2 - '1');

        int minmoves = bfs(src, dst);
        // DISPLAY THE OUTPUT OF BFS
        cout << minmoves << endl;
    }
}