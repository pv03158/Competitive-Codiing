#include <iostream>

class Node {
    public:
        int data;
        Node* left;
        Node* right;

        Node(int data) {
            this->data = data;
            left = right = NULL;
        }
};

using namespace std;
Node* constructTree(int pre[], char preLN[], int size, int &idx) {
    if(idx >= size) return NULL;
    if(preLN[idx] == 'L') {
        Node* node = new Node(pre[idx]);
        return node;
    }

    Node* root = new Node(pre[idx]);
    root->left = constructTree(pre, preLN, size, ++idx);
    root->right = constructTree(pre, preLN, size, ++idx);
    return root;
}

void displayTree(Node* root) {
    if(root == NULL) return;
    
    int leftC = root->left ? root->left->data : -1;
    int rightC = root->right ? root->right->data : -1;

    cout << leftC << " <= " << root->data << " => " << rightC << "\n";
    displayTree(root->left);
    displayTree(root->right);
}

int main(int argc, char* argv[]) {
    int pre[] = {10, 30, 20, 5, 15};
    char preLN[] = {'N', 'N', 'L', 'L', 'L'};

    int idx = 0;
    Node* root = constructTree(pre, preLN, 5, idx);
    displayTree(root);

    return 0;
}