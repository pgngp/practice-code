/* Minimum window substring (99):
Given a string S and a string T, find the minimum window in S which will 
contain all the characters in T in complexity O(n).
For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
http://www.programcreek.com/2014/05/leetcode-minimum-window-substring-java/ */

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

string getMinWindow(const string &s, const string &t)
{
	unordered_map<char, int> map;
	for (int i = 0; i < t.length(); ++i) {
		map[t[i]] = 0;
	}
	
	int start = 0, bestStart = -1, minLen = INT_MAX;
	unordered_set<int> set;
	for (int i = 0; i < s.length(); ++i) {
		if (map.count(s[i]) > 0 && set.count(s[i]) == 0) {
			set.insert(s[i]);
			++map[s[i]];
			
			while (set.size() == map.size()) {
				if (minLen > (i - start + 1)) {
					minLen = i - start + 1;
					bestStart = start;
				}
				
				--map[s[start]];
				if (map[s[start]] == 0) {
					set.erase(s[start]);
				}
				
				++start;
				while (start < i && map.count(s[start]) == 0) {
					++start;
				}
				
				if (start >= i) {
					break;
				}
			}
		} else if (set.count(s[i]) > 0) {
			++map[s[i]];
		}
	}
	
	return s.substr(bestStart, minLen);
}

int main(int argc, char **argv)
{
	if (argc < 3) {
		cout << "Usage: a.out <S> <T>" << endl;
		return 1;
	}
	
	string s(argv[1]);
	string t(argv[2]);
	cout << "S: " << s << ", t: " << t << endl;
	string minWindow = getMinWindow(s, t);
	cout << "Min window: " << minWindow << endl;
	 
	return 0;
}