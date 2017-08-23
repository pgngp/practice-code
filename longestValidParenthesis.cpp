/* Longest valid parentheses (128):
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
http://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/ */

#include <iostream>
#include <stack>

using namespace std;

int getLongestValidSeqLen(string s)
{
	int len = 0, maxLen = INT_MIN;
	stack<char> st;
	char c;
	
	for (int i = 0; i < s.length(); ++i) {
		if (!st.empty()) {
			maxLen = max(maxLen, len);
			len = 0;
		} else if (s[i] == '(') {
			st.push(s[i]);
		} else if (!st.empty()) {
			c = st.top();
			st.pop();
			len += 2;
		}	
	}
	maxLen = max(maxLen, len);
	
	return maxLen;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <str>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	int len = getLongestValidSeqLen(s);
	cout << "Longest valid sequence length of " << s << " is " << len << endl;
	
	return 0;
}