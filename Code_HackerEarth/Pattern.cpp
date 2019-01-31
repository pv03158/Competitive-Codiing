/*********************************************************************
For Input N = 9
Need to print : 
*       *
**     **
* *   * *
*  * *  *
*   *   *
*  * *  *
* *   * *
**     **
*       *
Similarly For other Odd
Values
**********************************************************************/
#include <iostream>
#include <cmath>

using namespace std;
int find_c(int N){
	for(int i=1;;i++)
		if(2*i + 1 == N)
			return i-1;
}

int
main(){
	int N;
	cin>>N;
	for(int i=-N/2;i<=N/2;i++){
		//1
		cout<<"*";
		//2
		if(abs(i)!=N/2)
			for(int j=0;j<-abs(i)+find_c(N);j++)
				cout<<" ";
		//3
		if(abs(i)!=N/2)
			cout<<"*";
		//4
		for(int k=0;k<abs(i)*2-1;k++)
			cout<<" ";
		//5
		if(abs(i)!=N/2 && i!=0)
			cout<<"*";
		//6
		if(abs(i)!=N/2)
			for(int l=0;l<-abs(i)+find_c(N);l++)
				cout<<" ";
		//7
		cout<<"*"<<endl;
	}
	return 0;
}