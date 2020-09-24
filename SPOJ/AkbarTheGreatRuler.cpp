#include <iostream>
#include <vector>
#include <utility>      // FOR PAIR
#include <queue>
#include <cstring>      // FOR MEMSET
#define BigInteger long long int

using namespace std;
bool bfs(vector<BigInteger> graph[], BigInteger cvtx, BigInteger stren, BigInteger vis[]) {
    if(vis[cvtx] != -1)
        return false;

    BigInteger basestn = cvtx;
    queue<pair<BigInteger, BigInteger>> q;
    q.push(make_pair(cvtx, 0));
    vis[cvtx] = basestn;

    while( !q.empty() ) {
        pair<BigInteger, BigInteger> ele = q.front();
        q.pop();
        cvtx = ele.first;
        int level = ele.second;

        // IF DISTANCE IS EQUAL TO GREATER THAN SOLDIER STRENGTH
        // NO NEED TO MOVE FURTHER
        if( level >= stren )
            return true;

        // GETTING NON-VISITED CHILDS OF CURRENT-VERTEX CVTX AND PUSH
        // THEM INSIDE THE QUEUE
        for(BigInteger nbr : graph[cvtx]) {
            if( vis[nbr] == basestn)
                continue;
            else if( vis[nbr] == -1 ) {
                q.push(make_pair(nbr, level + 1));
                vis[nbr] = basestn;
            }
            else        // EXECUTES WHEN NBR IS TRAVERSED OR UNDER SOME OTHER SOLDIER
                return false;
        }
    }
    return true;
}

int 
main(int argc, char* argv[]) {
    int t;
    cin >> t;

    while(t--) {
        BigInteger n, r ,m;
        cin >> n >> r >> m;

        // BUILDING GRAPH
        vector<BigInteger> graph[n];
        // TAKING INPUT OF EDGES
        for(BigInteger iter = 0 ; iter < r ; iter ++) {
            BigInteger a, b;
            cin >> a >> b;
            a -= 1;
            b -= 1;

            graph[a].push_back(b);
            graph[b].push_back(a);
        }

        BigInteger vis[n] ;
        memset(vis, -1, sizeof(vis));
        bool ans = true;
        // TAKING INPUT OF STATIONED SOLDIERS
        for(BigInteger iter = 0 ; iter < m ; iter ++) {
            BigInteger vtx ;
            BigInteger stren;

            cin >> vtx >> stren;
            if( ans )
                if( !bfs( graph, --vtx, stren, vis ) )
                    ans = false;
        }

        // ADDING CHECK FOR LEFT OUT POSTS
        for(int idx = 0 ; idx < n && ans ; idx++)
            if( vis[idx] == -1 )
                ans = false;

        // DISPLAYING OUTPUT
        (ans) ? cout << "Yes"<<endl : cout << "No" << endl;
        
    }
    return 0;
}