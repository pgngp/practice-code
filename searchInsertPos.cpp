/* Search insert position (136):
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order. 
You may assume no duplicates in the array. 
Here are few examples.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0
http://www.programcreek.com/2013/01/leetcode-search-insert-position/ */

#include <iostream>
#include <vector>

using namespace std;

int getIndex(const vector<int> &a, int target, int start, int end)
{
	int mid = (start + end) / 2;
	
	if (a[mid] == target) {
		return mid;
	} else if (a[mid] < target) {
		if ((mid + 1) > end || ((mid + 1) <= end && a[mid + 1] > target)) {
			return mid + 1;
		}
		
		return getIndex(a, target, mid + 1, end);
	} else {
		if ((mid - 1) < start || ((mid - 1) >= start && a[mid - 1] < target)) {
			return mid;
		}
		
		return getIndex(a, target, start, mid - 1);
	}
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "Usage: a.out <target> <arr size> <arr>" << endl;
		return 1;
	}
	
	int target = atoi(argv[1]);
	int aSize = atoi(argv[2]);
	vector<int> a;
	for (int i = 3; i < 3 + aSize; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	int idx = getIndex(a, target, 0, a.size() - 1);
	cout << "Index: " << idx << endl;
	
	return 0;
}