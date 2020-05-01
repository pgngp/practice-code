/* Pascal’s triangle (155):
Given numRows, generate the first numRows of Pascal's triangle. 
For example, given numRows = 5, the result should be:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
http://www.programcreek.com/2014/03/leetcode-pascals-triangle-java/ */

#include <iostream>

using namespace std;

int getFactorial(int n)
{
	int factorial = 1;
	
	for (int i = n; i > 0; --i) {
		factorial *= i;
	}
	
	return factorial;
}

void printPascalTriangle(int numRows)
{
	for (int i = 0; i < numRows; ++i) {
		for (int j = 0; j <= i; ++j) {
			int numerator = getFactorial(i);
			int denominator = getFactorial(j) * getFactorial(i - j);
			int val = numerator / denominator;
			cout << val << " ";
		}
		cout << endl;
	}
	cout << endl;
}

int main(int argc, char **argv) 
{
	if (argc < 2) {
		cout << "Usage: a.out <numRows>" << endl;
		return 1;
	}
	
	int numRows = atoi(argv[1]);
	printPascalTriangle(numRows);
	
	return 0;
}