/*************************************************************************************
Problem : 
You are given a sequence S of length N of character '(' and ')'. 
You have to delete exactly one character from S, such that after 
the deletion S is balanced parenthesis sequence. You have to tell 
if it possible or not to do so. 

Note: If given String is Empty or parenthesis is already balanced then Print 'YES'

For each test case, output "YES" if we can delete exactly one character
to make S balanced parenthesis sequence, else output "NO"
*************************************************************************************/
#include <iostream>

using namespace std;
int
main(){
	string str,stk;
	int counter = 0,top=-1;
	getline(cin,str);

	//Version 1.0
	// for(int i=0;i<str.length();i++){
	// 	if(str[i] == '(')
	// 		counter += 1;
	// 	if(str[i] == ')')
	// 		counter += -1;
	// }
	// if(counter == -1 || counter == 1 || counter == 0)
	// 	cout<<"YES";
	// else
	// 	cout<<"NO";

	//Version 2.0

	for(int i=0;i<str.length();i++){
		if(str[i] == '('){
			stk.push_back('(');
			top++;
		}

		if(str[i] == ')'){
			if(stk[top] == '('){
				stk.pop_back();
				top--;
			}
			else{
				stk.push_back(')');
				top++;
			}
		}
	}
	if(stk.length() == 0 || stk.length() == 1 )
		cout<<"YES";
	else
		cout<<"NO";
	return 0;
}