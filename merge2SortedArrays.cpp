/* There are two sorted arrays A and B of size m and n respectively. 
   Find the median of the two sorted arrays. The overall run time 
   complexity should be O(log (m+n)).
   http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/ */

#include <iostream>
#include <stdlib.h>
#include <vector>

using namespace std;

double median(vector<int> &a1, vector<int> &a2) {
	if (a1.size() > a2.size()) {
		return median(a2, a1);
	}
	
	int left = 0;
	int right = a1.size();
	int partX, partY, failedVal = -5555;
	int a1LeftMax, a2LeftMax, a1RightMin, a2RightMin;
	while (left <= right) {
		partX = (left + right) / 2;
		partY = ((a1.size() + a2.size() + 1) / 2) - partX;
		
		a1LeftMax = (partX == 0) ? INT_MIN : a1[partX - 1];
		a1RightMin = (partX == a1.size()) ? INT_MAX : a1[partX];
		
		a2LeftMax = (partY == 0) ? INT_MIN : a2[partY - 1];
		a2RightMin = (partY == a2.size()) ? INT_MAX : a2[partY];
		
		if (a1LeftMax <= a2RightMin && a2LeftMax <= a1RightMin) {
			if (((a1.size() + a2.size()) % 2) == 0) { // Even
				return ((double) max(a1LeftMax, a2LeftMax) + min(a1RightMin, a2RightMin)) / 2;
			} else { // Odd
				return max(a1LeftMax, a2LeftMax);
			}
		} else if (a2LeftMax > a1RightMin) {
			left = partX + 1;
		} else if (a1LeftMax > a2RightMin) {
			right = partX - 1;
		} else {
			return failedVal;
		}
	}
	
	return failedVal;
}

int main(int argc, char **argv) {
	if (argc < 5) {
		cerr << "Usage: " << argv[0] << " <arr1_size> <arr1> <arr2_size> <arr2>" << endl;
		exit(1);
	}
	
	vector<int> a1;
	int i;
	int a1Size = atoi(argv[1]);
	int len = a1Size + 2;
	for (i = 2; i < len; ++i) {
		a1.push_back(atoi(argv[i]));
	}
	
	vector<int> a2;
	int a2Size = atoi(argv[i]);
	++i;
	len = a2Size + i;
	for (; i < len; ++i) {
		a2.push_back(atoi(argv[i]));
	}
	
	double med = median(a1, a2);
	cout << "median: " << med << endl;
	
	return 0;
}