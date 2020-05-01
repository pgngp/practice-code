#include <string>
#include <iostream>

using namespace std;

bool isMatch(string &s, string &p) {
    int slen = s.length();
    int plen = p.length();

    // Create matrix
    bool **matrix = new bool*[slen + 1];
    for (int i = 0; i <= slen; ++i) {
        matrix[i] = new bool[plen + 1];
    }

    // Print initial matrix
    cout << "Pre-match matrix 1: " << endl;
    for (int i = 0; i <= slen; ++i) {
        for (int j = 0; j <= plen; ++j) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }

    // Initialize first row
    matrix[0][0] = true;
    for (int col = 1; col <= plen; col += 2) {
        if (p[col] != '*') {
            break;
        }
        matrix[0][col] = true;
        matrix[0][col + 1] = true;
    }

    // Print post-initialization matrix
    cout << "Pre-match matrix 2: " << endl;
    for (int i = 0; i <= slen; ++i) {
        for (int j = 0; j <= plen; ++j) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }

    // Compute the matrix
    for (int row = 1; row <= slen; ++row) {
        for (int col = 1; col <= plen; ++col) {
            if (s[row - 1] == p[col - 1] || p[col - 1] == '.') {
                matrix[row][col] = matrix[row - 1][col - 1];
            } else if (p[col - 1] == '*') {
                if (matrix[row][col - 2]) {
                    matrix[row][col] = matrix[row][col - 2];
                } else if (s[row - 1] == p[col - 2] || p[col - 2] == '.') {
                    matrix[row][col] = matrix[row - 1][col];
                }
            }
        }
    }

    // Print post-initialization matrix
    cout << "Post-match matrix 3: " << endl;
    for (int i = 0; i <= slen; ++i) {
        for (int j = 0; j <= plen; ++j) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }

    return matrix[slen][plen];
}

int main(int argc, char **argv) {
    if (argc < 3) {
        cout << "Usage: ./a.out <string> <pattern>" << endl;
        return -1;
    }

    string s = argv[1];
    string p = argv[2];
    cout << "s: " << s << endl;
    cout << "p: " << p << endl << endl;

    bool match = isMatch(s, p);
    cout << "match: " << match << endl;

    return 0;
}
