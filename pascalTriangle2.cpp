/* Pascal’s triangle II (152):
Given an index k, return the kth row of the Pascal's triangle. For example, when k = 3, the row is [1,3,3,1].
http://www.programcreek.com/2014/04/leetcode-pascals-triangle-ii-java/ */

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

void printKthRow(int k)
{
	for (int i = 0; i <= k; ++i) {
		int numerator = getFactorial(k);
		int denominator = getFactorial(i) * getFactorial(k - i);
		int val = numerator / denominator;
		cout << val << " ";
	}
	cout << endl;
}

int main(int argc, char **argv) 
{
	if (argc < 2) {
		cout << "Usage: a.out <numRows>" << endl;
		return 1;
	}
	
	int k = atoi(argv[1]);
	printKthRow(k);
	
	return 0;
}