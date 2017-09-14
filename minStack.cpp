/* Min stack (217):
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
http://www.programcreek.com/2014/02/leetcode-min-stack-java/ */

/* Run time: push/pop/top/getMin: O(1); space: O(n) */

#include <iostream>
#include <stack>

using namespace std;

class MinStack
{
private:
	stack<int> s;
	stack<int> min;
	
public:
	void push(int data);
	int pop();
	int top();
	int getMin();
};

void MinStack::push(int data)
{
	s.push(data);
	if (min.size() == 0 || data < min.top()) {
		min.push(data);
	}
}

int MinStack::pop()
{
	int top = s.top();
	if (top == min.top()) {
		min.pop();
	}
	s.pop();
	
	return top;
}

int MinStack::top()
{
	return s.top();
}

int MinStack::getMin()
{
	return min.top();
}

int main(int argc, char **argv)
{
	MinStack s;
	s.push(3);
	cout << "data: " << s.top() << ", min: " << s.getMin() << endl;
	s.push(4);
	cout << "data: " << s.top() << ", min: " << s.getMin() << endl;
	s.push(2);
	cout << "data: " << s.top() << ", min: " << s.getMin() << endl;
	s.pop();
	cout << "data: " << s.top() << ", min: " << s.getMin() << endl;
	
	return 0;
}