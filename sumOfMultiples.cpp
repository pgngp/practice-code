#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int getSumOfMultiples(int max, const vector<int> &nums)
{
	int sum = 0, j, multiple;
	unordered_set<int> s;
	
	for (int i = 0; i < nums.size(); ++i) {
		multiple = 0;
		j = 1;
		while (multiple < max) {
			s.insert(multiple);
			multiple = nums[i] * j;
			++j;
		}
	}
	
	for (unordered_set<int>::iterator it = s.begin(); it != s.end(); ++it) {
		sum += *it;
	}
	
	return sum;
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "Usage: a.out <max> <arr size> <arr>" << endl;
		return 1;
	}

	int max = atoi(argv[1]);
	int aSize = atoi(argv[2]);
	vector<int> nums;
	for (int i = 3; i < aSize + 3; ++i) {
		nums.push_back(atoi(argv[i]));
	}

	int val = getSumOfMultiples(max, nums);
	cout << "Sum of multiples: " << val << endl;
	
	// vector<int> nums;
	// nums.push_back(3);
	// nums.push_back(5);
	// if (getSumOfMultiples(0, nums) != 0) {
	// 	cout << "(0, sum_of_multiples::to({3, 5}, 0)) failed" << endl;
	// } else {
	// 	cout << "0, sum_of_multiples::to({3, 5}, 0)) succeeded" << endl;
	// }
	// if (getSumOfMultiples(4, nums) != 3) {
	// 	cout << "(3, sum_of_multiples::to({3, 5}, 4)) failed" << endl;
	// } else {
	// 	cout << "3, sum_of_multiples::to({3, 5}, 4)) succeeded" << endl;
	// }
	// if (getSumOfMultiples(10, nums) != 23) {
	// 	cout << "(3, sum_of_multiples::to({3, 5}, 4)) failed" << endl;
	// } else {
	// 	cout << "(3, sum_of_multiples::to({3, 5}, 4)) succeeded" << endl;
	// }
	// if (getSumOfMultiples(10000, nums) != 0) {
	// 	cout << "failed" << endl;
	// } else {
	// 	cout << "success" << endl;
	// }
	
	return 0;
}

/* Test cases:
(0, sum_of_multiples::to({3, 5}, 0));
(3, sum_of_multiples::to({3, 5}, 4));
(23, sum_of_multiples::to({3, 5}, 10));
(2318, sum_of_multiples::to({3, 5}, 100));
(233168, sum_of_multiples::to({3, 5}, 1000));
(51, sum_of_multiples::to({7, 13, 17}, 20));
(30, sum_of_multiples::to({4, 6}, 15));
(4419, sum_of_multiples::to({5, 6, 8}, 150));
(275, sum_of_multiples::to({5, 25}, 51));
(2203160, sum_of_multiples::to({43, 47}, 10000));
(4950, sum_of_multiples::to({1}, 100));
(0, sum_of_multiples::to({}, 10000));
*/