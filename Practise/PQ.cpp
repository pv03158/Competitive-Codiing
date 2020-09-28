#include <iostream>
#include <queue>
#include <functional>

using namespace std;
int
main(int argc, char* argv[]) {
    priority_queue<int, vector<int>, greater<int>> pq;
    pq.push(30);
    pq.push(10);
    pq.push(40);
    pq.push(20);

    while(pq.size() != 0) {
        cout << pq.front() << endl;
        pq.pop();
    }
}