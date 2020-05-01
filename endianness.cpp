// Check whether a system is little-endian or big-endian

#include <iostream>

using namespace std;

bool isLittleEndian()
{
	unsigned int i = 1;
	char *c;
	c = (char *) &i;
	if (*c > 0) {
		return true;
	}
	
	return false;
}

int main()
{
	if (isLittleEndian()) {
		cout << "Little endian" << endl;
	} else {
		cout << "Big endian" << endl;
	}
	return 0;
}