#include <iostream>
#include <thread>

using namespace std;

// Print some string
void print_something()
{
	cout << "Thread ID: " << this_thread::get_id() << endl;
}

int main(int argc, char **argv)
{
	// Create threads
	thread t1(print_something);
	thread t2(print_something);
	thread t3(print_something);
	
	// Wait for threads to complete
	t1.join();
	t2.join();
	t3.join();
	
	return 0;
}