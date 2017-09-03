/* Longest consecutive sequence (122):
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. 
Its length is 4. Your algorithm should run in O(n) complexity.
http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/ */

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int getLongestConsecutiveSequenceLen(vector<int> a)
{
	unordered_set<int> s;
	int currLen, maxLen = INT_MIN, j;
	for (int i = 0; i < a.size(); ++i) {
		currLen = 1;
		s.insert(a[i]);
		
		// Go back
		j = a[i] - 1;
		while (s.count(j) > 0) {
			++currLen;
			--j;
		}
		
		// Go forward
		j = a[i] + 1;
		while (s.count(j) > 0) {
			++currLen;
			++j;
		}
		
		maxLen = (maxLen < currLen) ? currLen : maxLen;
	}
	
	return maxLen;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <arr size> <arr>" << endl;
		return 1;
	}
	
	int aSize = atoi(argv[1]);
	vector<int> a;
	for (int i = 2; i < 2 + aSize; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	int len = getLongestConsecutiveSequenceLen(a);
	cout << "Len: " << len << endl;
	
	return 0;
}