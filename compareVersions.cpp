/* Compare version numbers (181):
Compare two version numbers version1 and version2. If version1 > version2 return 1, 
if version1 < version2 return -1, otherwise return 0. You may assume that the version 
strings are non-empty and contain only digits and the . character. The . character does 
not represent a decimal point and is used to separate number sequences. Here is an example 
of version numbers ordering:
0.1 < 1.1 < 1.2 < 13.37
http://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/ */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> tokenize(string s)
{
	vector<int> a;
	int i = 0, j = 0;
	while (j < s.size()) {
		if (s[j] == '.') {
			a.push_back(stoi(s.substr(i, j - i)));
			i = j + 1;
		}
		++j;
	}
	a.push_back(stoi(s.substr(i, j - i)));
	
	return a;
}

int compareVersions(string v1, string v2)
{
	if (v1.size() == 0 && v2.size() == 0) {
		return 0;
	} else if (v1.size() == 0) {
		return -1;
	} else if (v2.size() == 0) {
		return 1;
	}
	
	vector<int> v1Arr = tokenize(v1);
	vector<int> v2Arr = tokenize(v2);
	
	cout << "V1: ";
	for (int i = 0; i < v1Arr.size(); ++i) {
		cout << v1Arr[i] << " ";
	}
	cout << endl;
	
	cout << "V2: ";
	for (int i = 0; i < v2Arr.size(); ++i) {
		cout << v2Arr[i] << " ";
	}
	cout << endl;
	
	int i = 0, j = 0;
	while (i < v1Arr.size() && j < v2Arr.size()) {
		if (v1Arr[i] > v2Arr[j]) {
			return 1;
		} else if (v1Arr[i] < v2Arr[j]) {
			return -1;
		}
		
		++i;
		++j;
	}
	
	while (i < v1Arr.size()) {
		if (v1Arr[i] > 0) {
			return 1;
		}
		++i;
	}
	
	while (j < v2Arr.size()) {
		if (v2Arr[j] > 0) {
			return -1;
		}
		++j;
	}
	
	return 0;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <version1> <version2>" << endl;
		return 1;
	}
	
	string v1 = argv[1];
	string v2 = argv[2];
	int val = compareVersions(v1, v2);
	if (val == 1) {
		cout << v1 << " is greater than " << v2 << endl;
	} else if (val == -1) {
		cout << v1 << " is smaller than " << v2 << endl;
	} else {
		cout << v1 << " is equal to " << v2 << endl;
	}
	
	return 0;
}