/* Kadane's algorithm: max subarray sum */

#include <iostream>
#include <vector>

using namespace std;

int getMaxSubarrSum(const vector<int> &a)
{
	int currMax = a[0], overallMax = a[0];
	
	for (int i = 1; i < a.size(); ++i) {
		currMax = max(a[i], currMax + a[i]);
		overallMax = max(currMax, overallMax);
	}
	
	return overallMax;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <arr size> <arr>" << endl;
		return 1;
	} 
	
	int aSize = atoi(argv[1]);
	vector<int> a;
	for (int i = 2; i < aSize + 2; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "Arr: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	cout << "Max subarr sum: " << getMaxSubarrSum(a) << endl;
			
	return 0;
}