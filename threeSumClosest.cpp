/* 3 sum closest (74):
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/ */

#include <iostream>
#include <vector>

using namespace std;

int getClosestSum(vector<int> &a, int target)
{
	sort(a.begin(), a.end());
	
	int closestSum, minDiff = INT_MAX, i, j = 1, k = a.size() - 1, sum, diff;
	for (i = 0; i < j; ++i) {
		for (j = i + 1; j < k; ++j) {
			sum = a[i] + a[j] + a[k];
			diff = abs(target - sum);
			if (minDiff > diff) {
				minDiff = diff;
				closestSum = sum;
			}
			
			if (sum > target) {
				--k;
			}
		}
	}
	
	return closestSum;
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
	
	int closestSum = getClosestSum(a, target);
	cout << "Closest sum: " << closestSum << endl;
	
	return 1;
}