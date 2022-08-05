#pragma once
#include<vector>
#include"QueueLink.h"
using std::vector;
class Graph
{
private:
	int vertex;
	vector<vector<int>> adjacencyMatrix;
	QueueLink q;
public:
	Graph(int); // Constructor
	void creatGraphMatrix();
	void setVertex(int);
	void initializeMatrix();
	void printMatrix();
	void print(int);
	void Breadth_First_Search(int sourceVertex); // BFS
	void Depth_First_Search(int sourceVertex, vector<int>& visited); //DFS
	int minKey(vector<int>& key,vector<int>&mstSet);
	void Prim(); //Function for create Minimum Spanning Tree
	void printMinimumSpanningTree(vector<int>& parent);
};

