/* Largest number (154):
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. 
(Note: The result may be very large, so you need to return a string instead of an integer.)
http://www.programcreek.com/2014/02/leetcode-largest-number-java/ */

/* Run time: O(nlgn) */

#include <iostream>
#include <vector>

using namespace std;

bool compare(string s1, string s2)
{
	if (stoi(s1 + s2) >= stoi(s2 + s1)) {
		return true;
	}
	
	return false;
}

string getLargestNumber(vector<string> &a)
{
	if (a.size() == 0) {
		return "";
	} else if (a.size() == 1) {
		return a[0];
	}
	
	sort(a.begin(), a.end(), compare);
	
	string largestNumber = "";
	for (int i = 0; i < a.size(); ++i) {
		largestNumber += a[i];
	}
	
	return largestNumber;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <arr size> <arr>" << endl;
		return 1;
	}
	
	int aSize = atoi(argv[1]);
	vector<string> a;
	for (int i = 2; i < aSize + 2; ++i) {
		a.push_back(argv[i]);
	}
	
	cout << "Input arr: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	string num = getLargestNumber(a);
	cout << "Largest num: " << num << endl;
	
	return 0;
}