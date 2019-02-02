#include <iostream>

using namespace std;
int
main(){
	string s1,s2,s3;
	s1 = "Hello";
	s2 = "Wello";
	s3 += s1;
	s3.push_back('\n');
	s3 += s2;
	cout<<s1.substr(2,4);
	return 0;
}