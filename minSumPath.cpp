/* Triangle (141):
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
http://www.programcreek.com/2013/01/leetcode-triangle-java/ */

#include <iostream>
#include <vector>

using namespace std;

int getMinPathSum(const vector< vector<int> > &t)
{
	
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <num rows> <arr>" << endl;
		return 1;
	}
	
	int rows = atoi(argv[1]);
	int idx = 1;
	vector< vector<int> > t;
	for (int i = 0; i < rows; ++i) {
		t.push_back(vector<int>());
		for (int j = 0; j <= i; ++j) {
			t[i].push_back(atoi(argv[++idx]));
		}
	}
	
	for (int i = 0; i < t.size(); ++i) {
		for (int j = 0; j < t[i].size(); ++j) {
			cout << t[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
	
	return 0;
}