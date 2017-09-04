/* Valid palindrome (157):
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/ */

#include <iostream>
#include <string>

using namespace std;

bool isValidPalindrome(string s)
{
	int i = 0, j = s.length() - 1;
	while (i < j) {
		if (!isalnum(s[i])) {
			++i;
		} else if (!isalnum(s[j])) {
			--j;
		} else if (tolower(s[i]) == tolower(s[j])) {
			++i;
			--j;
		} else {
			return false;
		}
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
	
	if (isValidPalindrome(s)) {
		cout << "valid" << endl;
	} else {
		cout << "invalid" << endl;
	}
	
	return 0;
}