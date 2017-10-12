/* Find the difference between the square of the sum and the sum of the squares of
the first N natural numbers.
The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)2 = 552 =
3025.
The sum of the squares of the first ten natural numbers is 12 + 22 + ... + 102 = 385.
Hence the difference between the square of the sum of the first ten natural
numbers and the sum of the squares of the first ten natural numbers is 3025 - 385
= 2640. */

#include <iostream>
#include <math.h>

using namespace std;

long getDiff(int n)
{
	// Calculate square of sum
	long sum = 0;
	for (int i = 1; i <= n; ++i) {
		sum += i;
	}
	long sqOfSum = pow(sum, 2);
	
	// Calculate sum of squares
	long sumOfSq = 0;
	for (int i = 1; i <= n; ++i) {
		sumOfSq += pow(i, 2);
	}
	
	return sqOfSum - sumOfSq;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <N>" << endl;
		return 1;
	}
	
	int n = atoi(argv[1]);
	long diff = getDiff(n);
	cout << "Diff: " << diff << endl;
	
	return 0;
}