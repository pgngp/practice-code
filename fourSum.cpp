/* 4 sum (156):
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
http://www.programcreek.com/2013/02/leetcode-4sum-java/ */

#include <iostream>
#include <vector>

using namespace std;

void findTuple(vector<int> &a, int target)
{
	sort(a.begin(), a.end());
	
	int i, j = 1, k = 2, l = a.size() - 1, sum, prevI = INT_MIN, prevJ = INT_MIN, prevK = INT_MIN, prevL = INT_MIN;
	for (i = 0; i < j; ++i) {
		for (j = i + 1; j < k; ++j) {	
			for (k = j + 1; k < l; ++k) {		
				//cout << "      (" << a[i] << ", " << a[j] << ", " << a[k] << ", " << a[l] << ")" << endl;
				sum = a[i] + a[j] + a[k] + a[l];
				if (sum == target && (a[i] != prevI || a[j] != prevJ || a[k] != prevK || a[l] != prevL)) {
					cout << "(" << a[i] << ", " << a[j] << ", " << a[k] << ", " << a[l] << ")" << endl;
					prevI = a[i];
					prevJ = a[j];
					prevK = a[k];
					prevL = a[l];
				} else if (sum > target) {
					--l;
				} 
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