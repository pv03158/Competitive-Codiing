#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>
#include <unordered_map>
#include <stack>

using namespace std;
struct Node {
    string name;
    unordered_map<string, string> attributes;
    vector<Node*> children;
};

Node* HRMLParser(vector<string> hrml, unsigned int pos = 0) {
    if(hrml.size() <= pos || hrml.at(pos).substr(0,2) == "</")
        return NULL;

    string strbuff = hrml.at(0);
    strbuff.erase(remove(strbuff.begin(), strbuff.end(), '\"'), strbuff.end());
    strbuff.erase(remove(strbuff.begin(), strbuff.end(), '='), strbuff.end());
    
    // CHECKING FOR OPENING TAG
    Node* node = new Node;
    if( strbuff.substr(0, 2) != "</" ) {
        strbuff = strbuff.substr(1, strbuff.length() - 2);
        stringstream ss(strbuff);
        string attrib, value;
        ss >> node->name;
        while( ss >> attrib ) {
            ss >> value;
            node->attributes.emplace(attrib, value);
        }
    }

    node->children.push_back(HRMLParser(hrml, pos + 1));
    return node;
}
int
main(int argc, char* argv[]) {
    std::ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // ATTACHING INPUT.TXT WITH STDIN
    freopen("input.txt", "r", stdin);
    
    int n, q;
    cin >> n >> q;
    string strbuff;
    vector<string> hrml, query;
    getline(cin, strbuff);
    for(int iter = 0 ; iter < n ; iter ++) {
        getline(cin, strbuff, '\n');
        hrml.push_back(strbuff);
    }

    for(int iter = 0 ; iter < q ; iter++) {
        getline(cin, strbuff, '\n');
        query.push_back(strbuff);
    }

    Node* root = HRMLParser(hrml);
    cout << root->children.size();
}