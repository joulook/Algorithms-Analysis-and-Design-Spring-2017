#pragma once
class Node
{
	friend  class QueueLink;
public:
	int data;
	Node *next;
public:Node(int data);
};

