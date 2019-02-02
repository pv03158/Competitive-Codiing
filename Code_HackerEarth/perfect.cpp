#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
int
main(){
	vector <string> gc,pn;
	pn.push_back("66");
	pn.push_back("77");
	int N,start=0,end=2,counter=2,iter=1;
	cin>>N;
	while(counter < N){
		iter += 1;
		for(int i = start; i < end; i++){
			gc.push_back("6" + pn[i] + "6");
			counter++;
			if(counter == N)
				break;
		}
		for(int i = start; i < end; i++){
			gc.push_back("7" + pn[i] + "7");
			counter++;
			if(counter == N)
				break;
		}
		pn.clear();
		pn.resize(0);
		pn = gc;
		gc.clear();
		gc.resize(0);
		int size = end - start;
		N -= size;
		counter -= size;
		end = pow(2,iter);
	}
	cout<<pn[N-1];
}