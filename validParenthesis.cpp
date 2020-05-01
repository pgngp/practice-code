/* Valid parenthesis (204):
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/ */

#include <iostream>
#include <string>
#include <stack>

using namespace std;

bool isValid(string s)
{
	stack<char> st;
	char c;
	for (int i = 0; i < s.length(); ++i) {
		if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
			st.push(s[i]);
		} else {
			if (st.empty()) {
				return false;
			}
			
			c = st.top();
			st.pop();
			if (s[i] == ')' && c != '(') {
				return false;
			} else if (s[i] == ']' && c != '[') {
				return false;
			} else if (s[i] == '}' && c != '{') {
				return false;
			}
		}
	}
	
	if (!st.empty()) {
		return false;
	}
	
	return true;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <str>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	if (isValid(s)) {
		cout << "String " << s << " is valid" << endl;
	} else {
		cout << "String " << s << " is not valid." << endl;
	}
	
	return 0;
}