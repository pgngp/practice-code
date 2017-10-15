/* Remove element (219):
Given an array and a value, remove all instances of that value in place 
and return the new length. (Note: The order of elements can be changed. 
It doesn't matter what you leave beyond the new length.)
http://www.programcreek.com/2014/04/leetcode-remove-element-java/ */

#include <iostream>
#include <vector>

using namespace std;

int removeElement(vector<int> &a, int element)
{
	if (a.size() == 0) {
		return 0;
	}
	
	int j = 0;
	for (int i = 0; i < a.size(); ++i) {
		if (a[i] != element && j < i) {
			a[j] = a[i];
			++j;
		} else if (a[i] != element) {
			++j;
		}
	}
	
	return j;
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "Usage: a.out <element> <arr size> <arr>" << endl;
		return 1;
	}
	
	int element = atoi(argv[1]);
	int aSize = atoi(argv[2]);
	vector<int> a;
	for (int i = 3; i < aSize + 3; ++i) {
		a.push_back(atoi(argv[i]));
	}
	
	cout << "Before removal: ";
	for (int i = 0; i < a.size(); ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	int newSize = removeElement(a, element);
	cout << "After removal: ";
	for (int i = 0; i < newSize; ++i) {
		cout << a[i] << " ";
	}
	cout << endl;
	
	return 0;
}