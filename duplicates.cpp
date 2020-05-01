/* Contains duplicate (126):
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
http://www.programcreek.com/2014/05/leetcode-contains-duplicate-java/ */

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

bool hasDuplicate(const vector<int> &a)
{
	unordered_set<int> s;
	
	for (int i = 0; i < a.size(); ++i) {
		if (s.count(a[i]) > 0) {
			return true;
		} else {
			s.insert(a[i]);
		}
	}
	
	return false;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <aSize> <arr>" << endl;
		return 1;
	}
	
	int aSize = atoi(argv[1]);
	vector<int> a;
	for (int i = 2; i < aSize + 2; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "arr: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	if (hasDuplicate(a)) {
		cout << "Has duplicate" << endl;
	} else {
		cout << "No duplicates" << endl;
	}
	
	return 0;
}