/* Sieve of Eratosthenes: Print prime numbers not greater than the given value n */

#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

void printPrimeNumbers(int n)
{
	vector<bool> a(n + 1, true);
	
	int sqrtN = (int) ceil(sqrt(n));
	for (int i = 2; i <= sqrtN; ++i) {
		if (a[i] == false) {
			continue;
		}
		
		int sqI = pow(i, 2);
		int count = 0;
		for (int j = sqI; j <= n; j += i) {
			a[j] = false;
		}
	}
	
	cout << "Prime numbers: " << endl;
	for (int i = 2; i <= n; ++i) {
		if (a[i] == true) {
			cout << i << " ";
		}
	}
	cout << endl;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: a.out <max num>" << endl;
		return 1;
	} 
	
	int n = atoi(argv[1]);
	if (n <= 1) {
		cout << "The max number should be > 1" << endl;
		return 1;
	}
	
	printPrimeNumbers(n);
	
	return 0;
}