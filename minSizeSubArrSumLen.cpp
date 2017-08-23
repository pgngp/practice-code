/* Minimum size subarray sum (112):
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7, 
the subarray [4,3] has the minimal length of 2 under the problem constraint.
http://www.programcreek.com/2014/05/leetcode-minimum-size-subarray-sum-java/ */

#include <iostream>
#include <vector>

using namespace std;

int getMinSizeSubArrSumLen(const vector<int> &a, int target)
{
	int sum = 0, len = 0, minLen = INT_MAX;
	
	for (int i = 0; i < a.size(); ++i) {
		sum += a[i];
		++len;
		while (sum >= target) {
			minLen = min(minLen, len);
			--len;
			sum -= a[i - len];
		}
	}
	
	minLen = minLen == INT_MAX ? 0 : minLen;
	
	return minLen;
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
	
	cout << "target: " << target << endl;
	cout << "arr:" << endl;
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << endl;
	}
	cout << endl;
	
	int minLen = getMinSizeSubArrSumLen(a, target);
	cout << "minLen: " << minLen << endl;
	
	return 0;
}