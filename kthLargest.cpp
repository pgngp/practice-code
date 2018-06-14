/* Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example, given [3,2,1,5,6,4] and k = 2, return 5.
Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/ 

time: O(n) avg case; O(n^2) worst case when items are already sorted
*/

#include <iostream>
#include <vector>

using namespace std;

void swap(int *x, int *y) {
	int tmp = *x;
	*x = *y;
	*y = tmp;
}

int partition(vector<int> &a, int left, int right) {
	int pivot = a[right];
	int i = left - 1;
	int j = left;
	
	while (j < right) {
		if (a[j] < pivot && i < j) {
			++i;
			swap(&(a[i]), &(a[j]));
		}
		++j;
	}
	swap(&(a[i + 1]), &(a[j]));
	
	return i + 1;
}

int getKthLargest(vector<int> &a, int left, int right, int k) {
	if (a.size() == 0 || k > a.size()) {
		return INT_MIN;
	} else if (a.size() == 1) {
		return a[0];
	}
	
	int pivot;
	while (left <= right) {
		pivot = partition(a, left, right);
		
		if (pivot == k) {
			return a[k];
		} else if (pivot < k) {
			return getKthLargest(a, pivot + 1, right, k);
		} else {
			return getKthLargest(a, left, right - 1, k);
		}
	}
	
	return INT_MIN;
}

int main(int argc, char **argv) {
	if (argc < 4) {
		cerr << "Usage: " << argv[0] << " <arr_size> <arr>" << endl;
		exit(1);
	}
	
	int k = atoi(argv[1]);
	
	vector<int> a;
	int aSize = atoi(argv[2]);
	for (int i = 3; i < aSize + 3; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	int kthLargest = getKthLargest(a, 0, a.size() - 1, a.size() - k);
	cout << "kth largest: " << kthLargest << endl;
	
	return 0;
}