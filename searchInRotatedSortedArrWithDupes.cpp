/* Search in rotated sorted array II (51):
Follow up for "Search in Rotated Sorted Array": what if duplicates are allowed? 
Write a function to determine if a given target is in the array.
http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/ */

#include <iostream>
#include <vector>

using namespace std;

int find(const vector<int> &a, int left, int right, int target)
{
	if (left == right && a[left] == target) {
		return left;
	} else if (left > right) {
		return -1;
	}
	
	int mid = (left + right) / 2;
	if (a[mid] == target) {
		return mid;
	} else if (a[mid] < target) {
		if (a[mid] < a[right] && target > a[right]) {
			return find(a, left, mid - 1, target);
		} else {
			return find(a, mid + 1, right, target);
		}
	} else {
		if (a[mid] > a[right] && target <= a[right]) {
			return find(a, mid + 1, right, target);
		} else {
			return find(a, left, mid - 1, target);
		}
	}
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "Usage: a.out <target> <arrSize> <arr>" << endl;
		return 1;
	}
	
	int target = atoi(argv[1]);
	int aSize = atoi(argv[2]);
	vector<int> a;
	for (int i = 3; i < aSize + 3; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "Arr: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	int idx = find(a, 0, a.size() - 1, target);
	cout << "Index: " << idx << endl;
	
	return 0;
}