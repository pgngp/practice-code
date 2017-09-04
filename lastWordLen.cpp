/* Length of last word (160):
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string. If the last word does not exist, return 0.
http://www.programcreek.com/2014/05/leetcode-length-of-last-word-java/ */

#include <iostream>
#include <string>

using namespace std;

int getLastWordLen(string s)
{
	int i = s.length() - 1;
	while (i >= 0 && !isalpha(s[i])) {
		--i;
	}
	
	int len = 0;
	while (i >= 0 && isalpha(s[i])) {
		++len;
		--i;
	}
	
	return len;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <str>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	int len = getLastWordLen(s);
	cout << "last word len: " << len << endl;
	
	return 0;
}