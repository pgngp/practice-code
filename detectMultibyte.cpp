/* Given a stream of bytes, find out if it's a 1-byte, 2-byte, 3-byte, or 4-byte 
   character encoding and print the corresponding unicode character. 
   The following code will print:
     a: 1-byte
     1: 1-byte
     @: 1-byte
     ¥: 2-byte
     Ṗ: 3-byte
     𐀀: 4-byte
*/

#include <iostream>
#include <vector>
	
using namespace std;

void detectMultibyte(vector<unsigned char> arr) {
	char c[5];
	
	for (int i = 0; i < arr.size(); ++i) {
		unsigned char byte = arr[i];
		
		if ((byte & 128) == 0) {  // 1-byte
			c[0] = byte;
			c[1] = '\0';
			cout << c << ": 1-byte" << endl;
		} else if ((byte & 224) == 192) {  // 2-byte
			c[0] = byte;
			byte = arr[++i];
			c[1] = byte;
			c[2] = '\0';
			
			cout << c << ": 2-byte" << endl;
		} else if ((byte & 240) == 224) {  // 3-byte
			c[0] = byte;
			byte = arr[++i];
			c[1] = byte;
			byte = arr[++i];
			c[2] = byte;
			c[3] = '\0';
			
			cout << c << ": 3-byte" << endl;
		} else if ((byte & 248) == 240) {  // 4-byte
			c[0] = byte;
			byte = arr[++i];
			c[1] = byte;
			byte = arr[++i];
			c[2] = byte;
			byte = arr[++i];
			c[3] = byte;
			c[4] = '\0';
			
			cout << c << ": 4-byte" << endl;
		}
	}
}

int main(int argc, char** argv)
{
	vector<unsigned char> byteArr;
	// single byte
	byteArr.push_back('a');
	byteArr.push_back('1');
	byteArr.push_back('@');
	
	// U+00A5
	byteArr.push_back(0xC2);
	byteArr.push_back(0xA5);
	
	// U+1E56
	byteArr.push_back(0xE1);
	byteArr.push_back(0xB9);
	byteArr.push_back(0x96);
	
	// U+10000
	byteArr.push_back(0xF0);
	byteArr.push_back(0x90);
	byteArr.push_back(0x80);
	byteArr.push_back(0x80);
	detectMultibyte(byteArr);
	
	return 0;
}