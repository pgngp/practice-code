/* Longest common prefix (200):
Write a function to find the longest common prefix string amongst an array of strings.
http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/ */

#include <iostream>
#include <vector>

using namespace std;

string getLcp(vector<string> a)
{
	if (a.size() == 0) {
		return "";
	} 
	
	string lcp = a[0];
	for (int i = 1; i < a.size(); ++i) {
		while (a[i].find(lcp) == string::npos) {
			lcp = lcp.substr(0, lcp.size() - 1);
		}
		
		if (lcp.size() == 0) {
			return "";
		}
	}
	
	return lcp;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <arr size> <arr>" << endl;
		return 1;
	}
	
	int aSize = atoi(argv[1]);
	vector<string> a;
	for (int i = 2; i < aSize + 2; ++i) {
		a.push_back(argv[i]);
	}
	
	cout << "Input string arr: " << endl;
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << endl;
	}
	
	string lcp = getLcp(a);
	cout << "Longest common prefix: " << lcp << endl;
	
	return 0;
}