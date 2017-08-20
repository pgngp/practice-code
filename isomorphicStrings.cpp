#include <iostream>
#include <string>
#include <unordered_map>

/* Given two strings s and t, determine if they are isomorphic. 
Two strings are isomorphic if the characters in s can be replaced to get t.
For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.*/

using namespace std;

bool isIsomorphic(string s, string t)
{
	if (s.length() != t.length()) {
		return false;
	}
	
	unordered_map<char, char> um;
	
	for (int i = 0; i < s.length(); ++i) {
		if (um.count(s[i]) == 0) {
			um[s[i]] = t[i];
		} else if (um[s[i]] != t[i]) {
			return false;
		} 
	}
	
	return true;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <s> <t>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	string t(argv[2]);
	bool stringsIsomorphic = isIsomorphic(s, t);
	if (stringsIsomorphic) {
		cout << "Is isomorphic" << endl;
	} else {
		cout << "Is not isomorphic" << endl;
	}
	
	return 0;
}