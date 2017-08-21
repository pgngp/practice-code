#include <iostream>
#include <vector>

/**
 * Rotate an array of n elements to the right by k steps. For example, 
 * with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * http://www.programcreek.com/2015/03/rotate-array-in-java/
 */

using namespace std;

void rotateArr(vector<int> &arr, int k)
{
	if (arr.size() <= 1) {
		return;
	}
	
	int i = 0, j = arr.size() - k - 1, tmp;
	while (i < j) {
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		++i;
		--j;
	}
	
	i = arr.size() - k; 
	j = arr.size() - 1;
	while ( i < j) {
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		++i;
		--j;
	}
	
	i = 0;
	j = arr.size() - 1;
	while (i < j) {
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		++i;
		--j;
	}
}

int main(int argc, char **argv)
{
	int i, k;
	vector<int> arr;
	
	if (argc < 3) {
		cout << "Usage: a.out <k> <arr>" << endl;
		return 1;
	}
	
	k = atoi(argv[1]);
	
	for (i = 2; i < argc; ++i) {
		arr.push_back(atoi(argv[i]));
	}
	
	cout << "Before: ";
	for (i = 0; i < arr.size(); ++i) {
		cout << arr[i] << " ";
	}
	cout << endl;
	
	rotateArr(arr, k);
	
	cout << "After: ";
	for (i = 0; i < arr.size(); ++i) {
		cout << arr[i] << " ";
	}
	cout << endl;
	
	return 0;
}