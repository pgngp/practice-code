/* We have a coding system from alphabets to numbers where a=1, b=2, ...z=26. 
You are given a string of digits as an input. Write a function that will compute 
the number of valid interpretations of the input. 
Examples:
f('11')  = 2 Actual interpretations: 'aa', 'k'
f('111') = 3 Actual interpretations: 'aaa', 'ak', 'ka' */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int decodeCount(string digits)
{
	int len = digits.length();
	if (len == 0 || digits[0] == '0') {
		return 0;
	}
	if (len == 1) {
		return 1;
	}
	
	vector<int> arr(len, 0);
	
	// index 0
	arr[0] = 1;
	
	// index 1
	if (stoi(digits.substr(0, 2)) > 26) {
		if (digits[1] != '0') {
			arr[1] = 1;
		} else {
			arr[1] = 0;
		}
	} else {
		if (digits[1] != '0') {
			arr[1] = 2;
		} else {
			arr[1] = 1;
		}
	}
	
	// remaining indices
	for (int i = 2; i < len; ++i) {
		if (digits[i] != '0') {
			arr[i] += arr[i - 1];
		}
		
		int number = stoi(digits.substr(i - 1, 2));
		if (number < 26 && number > 10) {
			arr[i] += arr[i - 2];
		}
	}
	for (int i = 0; i < len; ++i) {
		printf("%d ", arr[i]);
	}
	printf("\n");
	
	return arr[len - 1];
}

int main(int argc, char **argv) {
	if (argc < 2) {
		cout << "Usage: ./a.out <input digits>" << endl;
		return 1;
	}
	
	string str(argv[1]);
	int count = decodeCount(str);
	cout << "string: " << str << ", count: " << count << endl;
	
	return 0;
}
