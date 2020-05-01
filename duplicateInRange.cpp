/* Contains duplicate II (124):
Given an array of integers and an integer k, return true if and only 
if there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the difference between i and j is at most k.
http://www.programcreek.com/2014/05/leetcode-contains-duplicate-ii-java/ */

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

bool hasDuplicate(const vector<int> &a, int k)
{
	unordered_map<int, int> m;
	for (int i = 0; i < a.size(); ++i) {
		if (m.count(a[i]) > 0 && i - m[a[i]] <= k) {
			cout << "m: " << m[a[i]] << ", " << i << endl;
			return true;
		}
		m[a[i]] = i;
	}
	
	return false;
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "Usage: a.out <k> <arrSize> <arr>" << endl;
		return 1;
	}
	
	int k = atoi(argv[1]);
	int aSize = atoi(argv[2]);
	vector<int> a;
	for (int i = 3; i < aSize + 3; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "k: " << k << endl;
	cout << "arr: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	if (hasDuplicate(a, k)) {
		cout << "Has Duplicate" << endl;
	} else {
		cout << "No duplicates" << endl;
	}
	
	return 0;
}