/* String to int (atoi) (214):
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/ */

#include <iostream>
#include <string>

using namespace std;

int strToInt(string s)
{
	int i = 0;
	bool isNeg = false;
	
	if (s[i] == '-') {
		++i;
		isNeg = true;
	}
	
	int num = 0;
	for (; i < s.length(); ++i) {
		if (s[i] < '0' || s[i] > '9') {
			return INT_MIN;
		}
		
		num = (num * 10) + (s[i] - '0');
	}
	
	if (isNeg) {
		return -1 * num;
	}
	
	return num;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <string>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	
	int val = strToInt(s);
	cout << "Val: " << val << endl;
	
	return 0;
}
