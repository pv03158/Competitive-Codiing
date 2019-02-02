#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
string bc(long long int num,long long int bits ){
	string bin_repr,rev_bin_repr;
	for(;num > 0; num /= 2){
		bin_repr += to_string(num%2);
	}
	while (bin_repr.length() < bits)
		bin_repr += "0";
	rev_bin_repr = bin_repr;
	reverse(bin_repr.begin(),bin_repr.end());
	return bin_repr+rev_bin_repr;
}

int
main(){
	string str;
	long long int N,sum=0,bits,diff;
	cin>>N;
	for( bits = 1;; bits++){
		if(N <= sum + pow(2,bits))
			break;
		else
			sum += pow(2,bits);
	}
	N - sum == 0 ? diff = pow(2,bits-1)-1 : diff = N - sum -1;
	str = bc(diff,bits);
	for(long long int i=0;i<str.length();i++)
		str[i] == '0' ? str[i] = '6' : str[i] = '7';
	cout<<str;
	return 0;
}