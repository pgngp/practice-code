/* Given an integer n, find it's fibanacci value. */

#include <iostream>

using namespace std;

int getFibonacci(int n)
{
    if (n < 0) {
        return INT_MIN;
    }
    else if (n == 0 || n == 1) {
        return 1;
    }

    int fn, fn_1 = 1, fn_2 = 1;
    for (int i = 2; i < n; ++i) {
        fn = fn_1 + fn_2;
        fn_2 = fn_1;
        fn_1 = fn;
    }

    return fn;
}

int main(int argc, char **argv)
{
	if (argc < 2) {
		cout << "Usage: ./a.out <n>" << endl;
		return 1;
	}
	
	int n = atoi(argv[1]);
	cout << "n: " << n << ", fib: " << getFibonacci(n) << endl;
	
	return 0;
}