#include "stdafx.h"
#include "Stack.h"
#include<iostream>
using namespace std;

Stack::Stack()
{
	topOfStack = NULL;
}
void Stack::push(int item) {
	Node *p = new Node(item);
	p->next =topOfStack;
	topOfStack = p;
}
int Stack::pop() {
	if (topOfStack == NULL) {
		cout << "stack is underflow!!\n";
		return -1;
	}
	int item;
	Node *p = topOfStack;
	item = p->data;
	topOfStack = topOfStack->next;
	delete p;
	return item;
}
bool Stack::Empty() {
	if (topOfStack == NULL)
		return true;
	else
		return false;
}



