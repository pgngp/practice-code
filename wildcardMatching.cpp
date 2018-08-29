#include <iostream>
#include <string>
#include <vector>

using namespace std;

int removeDuplicateStars(string &p) {
    // Base cases
    int plen = p.length();
    if (plen == 0 || plen == 1) {
        return plen;
    }

    // Remove duplicate
    int i = 1, j = 1;
    bool hasCopyStarted = false;
    while (j < plen) {
        if (!hasCopyStarted && p[i] == '*' && p[i - 1] == '*') {
            hasCopyStarted = true;
        }

        if (hasCopyStarted) {
            if (p[j] != '*' || p[i - 1] != '*') {
                p[i] = p[j];
                ++i;
            }
        } else {
            ++i;
        }
        ++j;
    }

    cout << "====================" << endl;
    cout << "p: " << p.substr(0, i) << endl;
    cout << "i: " << i << endl;
    cout << "====================" << endl;

    return i;
}

bool isMatch(string &s, string &p) {
    int strLen = s.length();
    int patternLen = removeDuplicateStars(p);

    bool **matrix = new bool*[strLen + 1];
    for (int i = 0; i <= strLen; ++i) {
        matrix[i] = new bool[patternLen + 1];
    }

    matrix[0][0] = 1;
    if (p[0] == '*') {
        matrix[0][1] = 1;
    }

    cout << "pre-match matrix: " << endl;
    for (int row = 0; row <= strLen; ++row) {
        for (int col = 0; col <= patternLen; ++col) {
            cout << matrix[row][col] << " ";
        }
        cout << endl;
    }

    for (int row = 1; row <= strLen; ++row) {
        for (int col = 1; col <= patternLen; ++col) {
            if (s[row - 1] == p[col - 1] || p[col - 1] == '?') {
                matrix[row][col] = matrix[row - 1][col - 1];
            } else if (p[col - 1] == '*' && (matrix[row - 1][col] == 1 || matrix[row][col - 1] == 1)) {
                matrix[row][col] = 1;
            }
        }
    }

    cout << "post-match matrix: " << endl;
    for (int row = 0; row <= strLen; ++row) {
        for (int col = 0; col <= patternLen; ++col) {
            cout << matrix[row][col] << " ";
        }
        cout << endl;
    }

    return matrix[strLen][patternLen] == 1;
}

int main(int argc, char const *argv[]) {
    if (argc < 3) {
        cout << "Usage: ./a.out <string> <pattern>" << endl;
        return -1;
    }

    string s = argv[1];
    string p = argv[2];

    cout << "s: " << s << ", slen: " << s.length() << endl;
    cout << "p: " << p << ", plen: " << p.length() << endl << endl;

    if (isMatch(s, p)) {
        cout << "MATCH" << endl;
    } else {
        cout << "NO MATCH" << endl;
    }

    return 0;
}
