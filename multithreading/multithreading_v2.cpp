#include <iostream>
#include <thread>
#include <mutex>

using namespace std;

mutex m;

// Print some string
void print_something(int thread_idx)
{	
	m.lock();
	cout << "Thread ID: " << thread_idx << " : " << this_thread::get_id() << endl;
	m.unlock();
}

int main(int argc, char **argv)
{
	// Create threads
	thread t1(print_something, 1);
	thread t2(print_something, 2);
	thread t3(print_something, 3);
	
	// Wait for threads to complete
	t1.join();
	t2.join();
	t3.join();
	
	return 0;
}