#include <condition_variable>
#include <mutex>
#include <thread>
#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>

using namespace std;

int num_writers = 0;
bool is_writing = false;
int num_reading = 0;
mutex m;
condition_variable cv;
vector<string> buffer;
const int maxSlots = 5;
int slotIdx = 0;

// Do reading
void read(int thread_idx)
{
	int idx = 0;
	bool readEverything = false;
	
	while (!readEverything) {
		unique_lock<mutex> uniq_lock(m);
		cv.wait(uniq_lock, []{return !is_writing;});
		++num_reading;

		// Do reading here
		if (idx < buffer.size()) {
			cout << "Reader " << thread_idx << ": " << buffer.at(idx) << endl;
			++idx;
		} else {
			readEverything = true;
		}

		--num_reading;
		uniq_lock.unlock();
		cv.notify_all();
	}
}

// Do writing
void write(int thread_idx)
{
	char char_buff[100];
	bool slotsFull = false;
	
	while (!slotsFull) {
		unique_lock<mutex> uniq_lock(m);
		++num_writers;
		cv.wait(uniq_lock, []{return num_reading == 0 && !is_writing;});
		is_writing = true;
		
		if (slotIdx < maxSlots) {
			// Do writing here
			sprintf(char_buff, "Writer %d: This is %d", thread_idx,  slotIdx);
			buffer.push_back(char_buff);
			++slotIdx;
		} else {
			slotsFull = true;
		}

		is_writing = false;
		--num_writers;
		uniq_lock.unlock();
		cv.notify_all();
	}
}

int main(int argc, char **argv)
{
	thread t1(write, 1);
	thread t2(write, 2);
	thread t3(write, 3);
	thread t4(read, 4);
	thread t5(read, 5);
	
	t1.join();
	t2.join();
	t3.join();
	t4.join();
	t5.join();
	
	return 0;
}