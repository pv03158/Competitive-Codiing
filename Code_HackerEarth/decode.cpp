#include <iostream>

using namespace std;
int
main(){
	int N,length_of_enc;
	string codes[100][2],huff_code,slc,decoded;
	cin>>N;
	for(int i=0;i<N;i++){
		cin>>codes[i][0];
		cin>>codes[i][1];
	}
	length_of_enc = codes[0][1].length();
	cin.ignore();
	getline(cin,huff_code);
	for(int j = 0;j <= huff_code.length();j += length_of_enc){
		slc = huff_code.substr(j,length_of_enc);
		for(int k = 0;k < N;k++){
			if(codes[k][1] == slc){
				if(codes[k][0] == "[newline]")
					decoded += '\n';
				else
					decoded += codes[k][0];
				break;
			}
		}
	}
	cout<<decoded;
	return 0;
}