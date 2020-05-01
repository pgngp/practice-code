/* Add binary (158):
Given two binary strings, return their sum (also a binary string). 
For example, a = "11", b = "1", the return is "100".
http://www.programcreek.com/2014/05/leetcode-add-binary-java/ */

#include <iostream>
#include <string>

using namespace std;

string add(const string &s1, const string &s2)
{
	int i = s1.length() - 1, j = s2.length() - 1, k, carry = 0, maxLen;
	maxLen = (s1.length() >= s2.length()) ? s1.length() : s2.length();
	string s3(maxLen + 1, ' ');
	k = s3.length() - 1;
	
	while (i >= 0 && j >= 0) {
		if (s1[i] == '1' && s2[j] == '1') {
			if (carry) {
				s3[k] = '1';
			} else {
				s3[k] = '0';
				carry = 1;
			}
		} else if (s1[i] == '1' || s2[j] == '1') {
			if (carry) {
				s3[k] = '0';
			} else {
				s3[k] = '1';
			}
			
		} else {
			if (carry) {
				s3[k] = '1';
				carry = 0;
			} else {
				s3[k] = '0';
			}
		}
		--i;
		--j;
		--k;
	}
	
	while (i >= 0) {
		if (s1[i] == '1') {
			if (carry) {
				s3[k] = '0';
			} else {
				s3[k] = '1';
			}
		} else {
			if (carry) {
				s3[k] = '1';
				carry = 0;
			} else {
				s3[k] = '0';
			}
		}
		--i;
		--k;
	}
	
	while (j >= 0) {
		if (s2[j] == '1') {
			if (carry) {
				s3[k] = '0';
			} else {
				s3[k] = '1';
			}
		} else {
			if (carry) {
				s3[k] = '1';
				carry = 0;
			} else {
				s3[k] = '0';
			}
		}
		--j;
		--k;
	}
	
	if (carry) {
		s3[k] = '1';
	}
	
	return s3;
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <num1> <num2>" << endl;
		return 1;
	}
	
	string s1(argv[1]);
	string s2(argv[2]);
	string s3 = add(s1, s2);
	cout << "s3: " << s3 << endl;
	
	return 0;
}