/* Merge sorted array (174):
Given two sorted integer arrays A and B, merge B into A as one sorted array.
Note: You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/ */

#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int> &a1, vector<int> &a2)
{
	int i = a1.size() - 1, j = a2.size() - 1, k = a1.capacity() - 1;
	
	while (i >= 0 && j >= 0) {
		if (a1[i] > a2[j]) {
			a1[k] = a1[i];
			--i;
		} else {
			a1[k] = a2[j];
			--j;
		}
		--k;
	}
	
	while (j >= 0) {
		a1[k] = a2[j];
		--k;
		--j;
	}
}

int main(int argc, char **argv)
{
	if (argc < 5) {
		cout << "Usage: a.out <arr1 size> <arr2 size> <arr1> <arr2>" << endl;
		return 1;
	}
	
	int a1Size = atoi(argv[1]);
	int a2Size = atoi(argv[2]);
	vector<int> a1;
	vector<int> a2;
	
	for (int i = 3; i < 3 + a1Size; ++i) {
		a1.push_back(atoi(argv[i]));
	}
	
	for (int i = 3 + a1.size(); i < 3 + a1.size() + a2Size; ++i) {
		a2.push_back(atoi(argv[i]));
	}
	
	a1.reserve(a1.size() + a2.size());
	
	merge(a1, a2);
	cout << "merged: " << endl;
	for (int i = 0; i < a1.capacity(); ++i) {
		cout << a1[i] << " ";
	}
	cout << endl;
	
	return 0;
}
