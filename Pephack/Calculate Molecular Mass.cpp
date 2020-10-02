#include <iostream>
#include <stack>

using namespace std;
int 
main(int argc, char* argv[]) {
    string str;
    cin >> str;

    str = '(' + str + ')';
    stack<int> st;
    for(int idx = 0 ; idx < str.length() ; idx++) {
        char ch = str.at(idx);
        if(ch == '(')   st.push(-1);
        if(ch == 'C')   st.push(12);
        if(ch == 'O')   st.push(16);
        if(ch == 'H')   st.push(1);

        if(ch == ')') {
            int asf = 0;
            while(st.top() != -1) {
                asf += st.top();
                st.pop();
            }
            st.pop();
            st.push(asf);
        }

        if(ch - '0' >= 2 && ch - '0' <= 9) {
            int asf = st.top();
            st.pop();
            asf *= ch - '0';
            st.push(asf);
        }
    }

    cout << st.top() << endl;
    return 0;
}