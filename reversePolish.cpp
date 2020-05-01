#include <iostream>
#include <vector>
#include <stack>

/* Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
Valid operators are +, -, *, /. Each operand may be an integer or another expression. 
For example:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6 
http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/ */

using namespace std;

int calc(const vector<string> &arr)
{
	stack<string> s;
	int op1, op2;

	for (int i = 0; i < arr.size(); ++i) {
		if (arr[i] != "+" && arr[i] != "-" && arr[i] != "*" && arr[i] != "/") {
			s.push(arr[i]);
		} else {
			op2 = stoi(s.top(), nullptr, 10);
			s.pop();
			op1 = stoi(s.top(), nullptr, 10);
			s.pop();

			if (arr[i] == "+") {
				s.push(to_string(op1 + op2));
			} else if (arr[i] == "-") {
				s.push(to_string(op1 - op2));
			} else if (arr[i] == "*") {
				s.push(to_string(op1 * op2));
			} else {
				s.push(to_string(op1 / op2));
			}
		}
	}

	return stoi(s.top(), nullptr, 10);
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "3+ args required" << endl;
		return 1;
	}
	
	vector<string> arr;
	for (int i = 1; i < argc; ++i) {
		arr.push_back(argv[i]);
	}
	
	cout << "Before: ";
	for (int i = 0; i < arr.size(); ++i) {
		cout << arr[i] << " ";
	}
	cout << endl;
	
	int val = calc(arr);
	cout << "Val: " << val << endl;
	
	return 0;
}