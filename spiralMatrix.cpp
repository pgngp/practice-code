/* Given a matrix, print it's contents in a spiral manner. */

#include <iostream>
#include <vector>

using namespace std;

void printSpiral(const vector< vector<int> > &m)
{
    int row = 0, col = -1, count = 0;
    int maxRow = m.size() - 1, maxCol = m[0].size() - 1;
    int minRow = 1, minCol = 0;
	int numElements = m.size() * m[0].size();

    while (count < numElements) {
        ++col;
        while (col <= maxCol) {
            cout << m[row][col] << " ";
            ++col;
            ++count;
        }
        --maxCol;
        --col;
		
		if (count >= numElements) {
			break;
		}

        ++row;
        while (row <= maxRow) {
            cout << m[row][col] << " ";
            ++row;
            ++count;
        }
        --maxRow;
        --row;
		
		if (count >= numElements) {
			break;
		}

        --col;
        while (col >= minCol) {
            cout << m[row][col] << " ";
            --col;
            ++count;
        }
        ++minCol;
        ++col;
		
		if (count >= numElements) {
			break;
		}

        --row;
        while (row >= minRow) {
            cout << m[row][col] << " ";
            --row;
            ++count;
        }
        ++minRow;
        ++row;
    }
}

int main()
{
    vector< vector<int> > m;
    m.push_back(vector<int>());
    m.push_back(vector<int>());
    m.push_back(vector<int>());
    m[0].push_back(1);
    m[0].push_back(2);
    m[1].push_back(3);
	m[1].push_back(4);
    m[2].push_back(5);
    m[2].push_back(6);
	
	cout << "Orig matrix: " << endl;
    for (int i = 0; i < m.size(); ++i) {
        for (int j = 0; j < m[0].size(); ++j) {
            cout << m[i][j] << " ";
        }
        cout << endl;
    }
	cout << endl;

    cout << "Printing spiral:" << endl;
    printSpiral(m);
    cout << endl << "done" << endl;

	return 0;
}