#include <iostream>
#include <vector>
#include <random>
#include <chrono>
#include <cstring>
#include <algorithm>

using namespace std;
int 
main(int argc, char* argv[]) {
    ios_base::sync_with_stdio(false);
	cin.tie(0), cout.tie(0);

    const int base = 2;
    uint64_t mod = 247184691349;
    mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
    int64_t n, m;
    cin >> n >> m;

    // CREATING GRAPH 
    vector<int64_t> graph[n+1];
    for(int64_t idx = 0 ; idx < m ; idx++) {
        int64_t u, v;
        cin >> u >> v;
        
        // ADDING EDGES INTO THE GRAPH
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    
    for(int idx = 1 ; idx <= n ; idx++)
        sort(graph[idx].begin() , graph[idx].end());
    // CREATING HASH FOR THE VERTICES
    int64_t vtx_hash[n+1];
    vtx_hash[0] = 1;
    for(uint64_t idx = 1; idx <= n ; idx++)
        vtx_hash[idx] = rng() % mod;

    // GENERATING HASH OF GRAPH
    int64_t graph_hash[n + 1];
    memset(graph_hash, 0 ,sizeof(graph_hash));
    for(int64_t idx = 1 ; idx <= n ; idx++) {
        for(int64_t v : graph[idx])
            graph_hash[idx] = (graph_hash[idx] + vtx_hash[v]) % mod;
    }

    // FINDING ANSWER
    int64_t counter = 0;
    for(int64_t i = 1 ; i <= n ; i++) {
        for(int64_t v : graph[i]) {
            int64_t hash1 = (graph_hash[i] - vtx_hash[v] + mod) % mod;
            int64_t hash2 = (graph_hash[v] - vtx_hash[i] + mod) % mod;
            if( hash1 == hash2 )
                counter ++;
        }
    }

    // HENCE COUNTER TAKES THE VALUE OF BOTH VERTICES OF AN EDGE
    counter /= 2;
    sort(graph_hash + 1, graph_hash + n + 1);
    int64_t cons_counter = 1;
    graph_hash[ n + 1] = -1;
    for(int i = 2 ; i <= n + 1 ; i++) {
        if(graph_hash[i] == graph_hash[i - 1])
            cons_counter ++;
        else {
            counter += (cons_counter * (cons_counter - 1)) / 2;
            cons_counter = 1;
        }
    }

    cout << counter << endl;
}