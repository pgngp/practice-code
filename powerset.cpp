/* Powerset of a set 

Run time: O(n*2^n)
Space: O(1)
*/

#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

void printPowerset(const vector<int> &a)
{
	int powerSetSize = pow(2, a.size());
	cout << "()" << endl;
	for (int i = 1; i < powerSetSize; ++i) {
		int k = i;
		for (int j = a.size() - 1; j >= 0; --j) {
			if ((k & 1) == 1) {
				cout << a[j] << " ";
			}
			k >>= 1;
		}
		cout << endl;
	}
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <arrSize> <arr>" << endl;
		return 1;
	}
	
	int aSize = atoi(argv[1]);
	vector<int> a;
	for (int i = 2; i < aSize + 2; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "Set: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	cout << "Powerset:" << endl;
	printPowerset(a);
	
	return 0;
}