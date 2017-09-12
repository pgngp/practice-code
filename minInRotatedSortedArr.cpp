/* Find minimum in rotated sorted array (156):
Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.You may assume no duplicate exists in the array.
http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/ */

#include <iostream>
#include <vector>

using namespace std;

int getMin(const vector<int> &a, int left, int right)
{
	if (left == right) {
		return a[left];
	} else if (left > right) {
		return INT_MIN;
	}
	
	int mid = (left + right) / 2;
	if (a[mid] > a[right]) {
		return getMin(a, left + 1, right);
	} else {
		if (left < mid && a[mid - 1] > a[mid]) {
			return a[mid];
		} else if (left == mid) {
			return a[mid];
		}
		return getMin(a, left, mid - 1);
	}
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
	
	int min = getMin(a, 0, a.size() - 1);
	cout << "Min: " << min << endl;
	
	return 0;
}