#include <iostream>
#include <vector>

using namespace std;
int
main(){
	vector <int> lt;
	int tmp;
	for(;tmp != 42;){
		cin>>tmp;
		lt.push_back(tmp);
	}
	for(int i=0;i<lt.size()-1;i++)
		cout<<lt[i]<<endl;
	return 0;
}
