#include "stdafx.h"
#include "QueueLink.h"
#include"Node.h"
#include<iostream>
using namespace std;
QueueLink::QueueLink()
{
	front = rear = NULL;
}
void QueueLink::enQueue(int item) {
	Node *p = new Node(item);
	if (front == NULL) { //Queue is Empty??
		front = rear = p;
		p->next = NULL;
	}
	else {
		rear->next = p;
		rear = p;
	}
}
int QueueLink::delQueue() {
	if (front ==NULL) {
		cout << "Queue is Empty.\n";
		return -1;
	}
	else {
		int item = front->data;
		Node *p = front;
		front = front->next;
		delete p;
		return item;
	}
}
bool QueueLink::Empty() {
	return (front == NULL);
}



