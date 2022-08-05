#include "stdafx.h"
#include "Graph.h"
#include<iostream>
#include<vector>
using std::vector;
using namespace std;
Graph::Graph(int vertex_Graph)
{
	setVertex(vertex_Graph);
}
//*********************************************
void Graph:: setVertex(int vertex_Graph) {
	vertex = vertex_Graph;
	creatGraphMatrix();
	initializeMatrix();
}
//*********************************************
void Graph::creatGraphMatrix() {
	adjacencyMatrix.resize(vertex);
	for (int i = 0; i < vertex; i++) {
		adjacencyMatrix[i].resize(vertex);
	}
}
//**********************************************
void Graph::initializeMatrix() {
	cout << "enter elements of Undirected weighted graph adjacency matrix  :\n\n";
//*********************************** read elements of matrix 
	for (int i = 0; i < vertex; i++) {
		for (int j = 0; j < vertex; j++) {
			cout << "adjacencyMatrix[" << i << "][" << j << "]:";
			cin >> adjacencyMatrix[i][j];
		}
	}
}
//***********************************
void Graph::printMatrix() {
	    cout << " { {";
	for (int i = 0; i < vertex; i++) {
		for (int j = 0; j < vertex; j++) {
			print(adjacencyMatrix[i][j]);
		}
		if (i == vertex - 1)
			cout << "} }";
		else
			cout << "}\n   {";
	}
	cout << "\n";
}
void Graph::print(int number) {
	int num = number;
	int c = 1;
	while (num/10!= 0){
		c++;
		num /= 10;
	}
	if (c == 1)
		cout << number << "     ";
	else if (c == 2)
		cout << number << "    ";
	else if (c == 3)
		cout << number << "   ";
	else if (c == 4)
		cout << number << "  ";
	else if (c == 5)
		cout << number << " ";
	else if (c == 6)
		cout << number;
}
void Graph::Breadth_First_Search(int sourceVertex) {
	vector<int>visited; //initialize with zero
	visited.resize(vertex);
	int currentVertex;
	QueueLink queue;
	queue.enQueue(sourceVertex); //enter to first of queue
	visited[sourceVertex] = 1;
	while (!queue.Empty()) {
		currentVertex = queue.delQueue();
		cout << currentVertex + 1 << "  ";
		for (int i = 0; i < vertex; i++) {
			if (adjacencyMatrix[currentVertex][i] < INT_MAX && adjacencyMatrix[currentVertex][i]!=0 && visited[i]!=1) {
				queue.enQueue(i);
				visited[i] = 1;
			}
		}
	}
}
//*****************************************************
//recursive function DFS
void Graph::Depth_First_Search(int sourceVertex, vector<int>& visited) {
	if (visited[sourceVertex] != 1) {
		visited[sourceVertex] = 1;
		cout << sourceVertex + 1 << "  ";
		for (int i = 0; i < vertex; i++) {
			if (adjacencyMatrix[sourceVertex][i]<INT_MAX && adjacencyMatrix[sourceVertex][i]!=0 && visited[i] != 1) {
				Depth_First_Search(i, visited);
			}
		}
	}
}
int Graph::minKey(vector<int>& key, vector<int>& mstSet) {
	int min = INT_MAX, min_index;

	for (int i = 0; i < vertex; i++) {
		if (mstSet[i] == 0 && key[i] < min) {
			min = key[i];
			min_index = i;
		}
	}
	return min_index;
}
//*****************************************************
//prim algorithm 
void Graph::Prim() {
	// this array to store constructed Minimum Spanning Tree
	vector<int>parent; 
	parent.resize(vertex);
	//****************
	vector<int>key;
	key.resize(vertex);
	// Key values used to pick minimum weight edge in cut

	vector<int>mstSet;
	mstSet.resize(vertex);
	//mstSet array To represent set of vertices not yet included in MST

	//initialize
	for (int i = 0; i < vertex; i++) {
		key[i] = INT_MAX;
		mstSet[i] = 0;
	}
	key[0] = 0;
	parent[0] = -1;

	for (int i = 0; i < vertex - 1; i++) {
		int u = minKey(key, mstSet);
		mstSet[u] =1;

		for (int j = 0; j < vertex; j++) {
			if (adjacencyMatrix[u][j] && mstSet[j] == 0 && adjacencyMatrix[u][j] < key[j])
				parent[j] = u;
			key[j] = adjacencyMatrix[u][j];
		}
	}

	printMinimumSpanningTree(parent);

}
void Graph::printMinimumSpanningTree(vector<int>& parent) {
	cout << "Edge     Weight \n";
	for (int i = 1; i < vertex; i++) {
		cout << parent[i] << " - " << i << "  " << adjacencyMatrix[i][parent[i]] << "\n";
	}
}



