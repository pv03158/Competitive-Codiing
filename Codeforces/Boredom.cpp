#include <iostream>
#include <unordered_map>

using namespace std;
int dfs(unordered_map<int, pair<int, int>> &hm) {
    int asf = 0;
    for(auto iter = hm.begin() ; iter != hm.end() ; iter ++) {
        int key = iter->first;
        int left = key - 1;
        int right = key + 1;

        if( !hm.at(key).first && hm.at(key).second > 0) {
            if(hm.find(left) != hm.end())
                hm.at(left).first ++ ;
            if(hm.find(right) != hm.end())
                hm.at(right).first ++ ;

            hm.at(key).second -= 1;
            asf = max(asf, dfs(hm) + key);

            if(hm.find(left) != hm.end())
                hm.at(left).first -- ;
            if(hm.find(right) != hm.end())
                hm.at(right).first -- ;
        }
    }

    return asf;
}

int
main(int argc, char* argv[]) {
    // TAKING INPUT FROM CONSOLE
    int n;
    cin >> n;
    int arr[n];
    for(int idx = 0 ; idx < n ; idx++)
        cin >> arr[idx];
    
    // BUILDING HASHMAP OF IT
    unordered_map<int, pair<int, int>> hm;
    for(int idx = 0 ; idx < n ; idx++)
        if( hm.find(arr[idx] ) == hm.end())
            hm.insert({ arr[idx], {0, 1}});
        else 
            hm.at( arr[idx] ).second += 1;
    
    cout << dfs(hm);
}