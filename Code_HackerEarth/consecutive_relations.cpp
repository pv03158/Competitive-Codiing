#include <iostream>

using namespace std;
int
main(){
	int N,counter = 0,sum;
	cin>>N;
	for(int i=1;i<N;i++){
		sum = 0;
		for(int j=i;;j++){
			sum += j;
			if(sum>N)
				break;
			if(sum == N){
				counter++;
				break;
			}
		}
	}
	cout<<counter;
}