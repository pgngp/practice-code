/* Find maximum subsequence sum:
1, 2, 3 -> 6
1, -6, 3 -> 3
3, -1, 3 -> 5
*/

#include <iostream>
#include <vector>

using namespace std;

int getMaxSum(const vector<int> &numbers) {
    int sum = 0, maxSum = INT_MIN;
    
    for (int i = 0; i < numbers.size(); ++i) {
        sum += numbers[i];
		
		if (sum > maxSum) {
			maxSum = sum;
		} else if (sum < 0) {
			sum = 0;
		}
    }
    
    return maxSum;
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
	
	int maxSum = getMaxSum(a);
	cout << "MaxSum: " << maxSum << endl;
	
	return 0;
}
