/* 3 sum (197):
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
For example, given array S = {-1 0 1 2 -1 -4},
A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
http://www.programcreek.com/2012/12/leetcode-3sum/ */

#include <iostream>
#include <vector>

using namespace std;

void findTuple(vector<int> &a, int target)
{
	sort(a.begin(), a.end());
	
	int i = 0, j = a.size() - 1, k, sum, val;
	while (i < j) {
		k = i + 1;
		while (k < j) {
			sum = a[i] + a[j] + a[k];
			if (sum == target) {
				cout << "(" << a[i] << ", " << a[k] << ", " << a[j] << ")" << endl;
				val = a[k];
				while (val == a[k] && k < j) {
					++k;
				}
				if (k >= j) {
					break;
				}
			} else if (sum > target) {
				val = a[j];
				while (j > i && val == a[j]) {
					--j;
				}
			} else {
				val = a[k];
				while (k < j && val == a[k]) {
					++k;
				}
			}
		}
		
		if (k >= j) {
			val = a[i];
			while (i < j && a[i] == val) {
				++i;
			}
		}
	}
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <target> <size> <array>" << endl;
		return 1;
	}
	
	int target = atoi(argv[1]);
	int aSize = atoi(argv[2]);
	vector<int> a;
	for (int i = 3; i < 3 + aSize; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	findTuple(a, target);
	
	return 1;
}