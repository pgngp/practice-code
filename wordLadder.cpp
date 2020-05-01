/* Word ladder (153):
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. 
For example, given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
http://www.programcreek.com/2012/12/leetcode-word-ladder/ */

/* Run time: O(n*m) (n: dict size; m: word size); space: O(n) */

#include <iostream>
#include <unordered_set>
#include <unordered_map>
#include <queue>

using namespace std;

int getDistance(string s1, string s2)
{
	int distance = 0;
	for (int i = 0; i < s1.length(); ++i) {
		if (s1[i] != s2[i]) {
			++distance;
		}
	}
	
	return distance;
}

int findShortestTransformationPath(string start, string end, const unordered_set<string> &dict)
{
	string alphabets = "abcdefghijklmnopqrstuvwxyz";
	unordered_set<string> parsedSet; 
	queue<string> q;
	queue<int> numTransformationsQueue;
	q.push(start);
	int numTransformations = 1;
	numTransformationsQueue.push(numTransformations);
	parsedSet.insert(start);
	
	string s, s2;
	while (!q.empty()) {
		s = q.front();
		q.pop();
		numTransformations = numTransformationsQueue.front();
		numTransformationsQueue.pop();
		
		if (getDistance(s, end) == 1) {
			return numTransformations + 1;
		}
		
		++numTransformations;
		for (int i = 0; i < s.length(); ++i) {
			for (int j = 0; j < alphabets.length(); ++j) {
				s2 = s;
				s2[i] = alphabets[j];
				if (parsedSet.count(s2) == 0 && dict.count(s2) > 0) {
					q.push(s2);
					numTransformationsQueue.push(numTransformations);
					parsedSet.insert(s2);
				}
			}
		}
	}
	
	return -1;
}

int main(int argc, char **argv)
{
	if (argc < 4) {
		cout << "Usage: a.out <start> <end> <dictword1> [<dictword2> <dictword3> ...]" << endl;
		return 1;
	}
	
	string start(argv[1]);
	string end(argv[2]);
	unordered_set<string> dict;
	for (int i = 3; i < argc; ++i) {
		dict.insert(string(argv[i]));
	}
	
	int numTransformations = findShortestTransformationPath(start, end, dict);
	cout << "Num transformations: " << numTransformations << endl;
	
	return 0;
}