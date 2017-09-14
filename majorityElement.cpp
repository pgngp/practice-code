/* Majority element (167):
Given an array of size n, find the majority element. The majority element 
is the element that appears more than ⌊ n/2 ⌋ times. (assume that the array 
is non-empty and the majority element always exist in the array.)
http://www.programcreek.com/2014/02/leetcode-majority-element-java/ */

/* Run time: O(n); space: O(1) */

#include <iostream>
#include <vector>

using namespace std;

int getMajorityElement(const vector<int> &a)
{
	int count = 0, result = a[0];
	
	for (int i = 0; i < a.size(); ++i) {
		if (count == 0) {
			result = a[i];
			count = 1;
		} else if (result == a[i]) {
			++count;
		} else {
			--count;
		}
	}
	
	return result;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <arrSize> <arr>" << endl;
		return 1;
	}
	
	int aSize = atoi(argv[1]);
	vector<int> a;
	for (int i = 2; i < aSize + 2; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "Arr: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	int majorityElement = getMajorityElement(a);
	cout << "Majority element: " << majorityElement << endl;
	
	return 0;
}