/* Majority element II (78):
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.
http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/ */

#include <iostream>
#include <vector>

using namespace std;

void printMajorityElements(const vector<int> &a)
{
	int c1 = 0, c2 = 0, m1, m2;
	
	for (int i = 0; i < a.size(); ++i) {
		if (c1 == 0) {
			m1 = a[i];
			++c1;
		} else if (m1 == a[i]) {
			++c1;
		} else if (c2 == 0) {
			m2 = a[i];
			++c2;
		} else if (m2 == a[i]) {
			++c2;
		} else {
			--c1;
			--c2;
		}
	}
	
	cout << "m1: " << m1 << ", m2: " << m2 << endl;
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
	
	printMajorityElements(a);
	
	return 0;
}