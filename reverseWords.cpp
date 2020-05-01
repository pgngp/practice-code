/* Reverse words in a string (252):
Given an input string, reverse the string word by word. 
For example, given s = "the sky is blue", return "blue is sky the".
http://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/ */

#include <iostream>
#include <string>

using namespace std;

void reverse(string &s)
{
	int i = 0, j = s.length() - 1;
	char c;
	
	// Reverse string
	while (i < j) {
		c = s[i];
		s[i] = s[j];
		s[j] = c;
		++i;
		--j;
	}
	
	// Reverse each word
	int end = 0;
	i = 0;
	while (end < s.length()) {
		while (s[end] != ' ' && s[end] != '\0') {
			++end;
		}
		
		j = end - 1;
		while (i < j) {
			c = s[i];
			s[i] = s[j];
			s[j] = c;
			++i;
			--j;
		}
		++end;
		i = end;
	}
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <str>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	cout << "Orig: " << s << endl;
	reverse(s);
	cout << "Reversed: " << s << endl;
	
	return 0;
}