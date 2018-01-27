#include <condition_variable>
#include <mutex>
#include <thread>
#include <iostream>

using namespace std;

int num_writers = 0;
bool is_writing = false;
int num_reading = 0;
mutex m;
condition_variable cv;

// Do reading
void read(int thread_idx)
{
	unique_lock<mutex> uniq_lock(m);
	cv.wait(uniq_lock, []{return !is_writing;});
	++num_reading;

	// Do reading here

	--num_reading;
	uniq_lock.unlock();
	cv.notify_all();
}

// Do writing
void write(int thread_idx)
{
	unique_lock<mutex> uniq_lock(m);
	++num_writers;
	cv.wait(uniq_lock, []{return num_reading == 0 && !is_writing;});
	is_writing = true;

	// Do writing here

	is_writing = false;
	--num_writers;
	uniq_lock.unlock();
	cv.notify_all();
}

int main(int argc, char **argv)
{
	thread t1(read, 1);
	thread t2(write, 1);
	thread t3(read, 2);
	thread t4(write, 2);
	
	t1.join();
	t2.join();
	t3.join();
	t4.join();
	
	return 0;
}