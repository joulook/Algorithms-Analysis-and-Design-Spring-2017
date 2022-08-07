#pragma once
#include"Node.h"
class QueueLink
{
public :
	Node *front;
	Node *rear;
public:
	QueueLink();
	void enQueue(int);
	int delQueue();
	bool Empty();
	
};

