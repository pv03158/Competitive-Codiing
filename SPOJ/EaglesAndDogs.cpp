#include <iostream>
#include <vector>
#include <array>

using namespace std;


int
dfs(vector<pair<int,int> > graph[], int cvtx, int parent) {
    int maxlength = 0;
    for(int idx = 0 ; idx < graph[cvtx].size() ; idx++) {
        pair<int, int> p = graph[cvtx][idx];
        if(p.first != parent) {
            int cpath = dfs(graph, p.first, cvtx) + p.second;
            maxlength = maxlength > cpath ? maxlength : cpath;
        }
    }

    return maxlength;
}

int
main(int arc, char* argv[]) {
    int t;
    cin >> t;

    while(t--) {
        int n;
        cin >> n;
        vector<pair<int, int> > graph[n];

        // CREATING GRAPH FROM USER INPUT
        for(int iter = 0 ; iter < n - 1; iter ++) {
            int vtx1, vtx2, wt;
            cin >> vtx1 >> vtx2 >> wt;

            vtx1 -- ;
            vtx2 --;
            
            graph[vtx1].push_back(make_pair(vtx2, wt));
            graph[vtx2].push_back(make_pair(vtx1, wt));
        }

        // APPLYING DFS AT EVERY POINT
        for(int vtx = 0 ; vtx < n ; vtx++) {
            cout << dfs(graph, vtx, -1) << " ";
        }
        cout << endl;

    }

    return 0;
}