// algorithmGraph.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include"Graph.h"
#include"QueueLink.h"
#include<iostream>
#include<vector>
using std::vector;

using namespace std;
int main()
{
	int vertex;
	cout << "Enter vertex of graph : \n";
	cin >> vertex;
	Graph graph(vertex);
	cout << "\nBFS Traverse :\n";
	graph.Breadth_First_Search(0);
	cout << "\n";
	vector<int>visited;
	visited.resize(vertex);
	cout << "\nDFS Traverse :\n";
	graph.Depth_First_Search(0,visited);

	cout << "\nMinimum Spanning Tree with prim's algorithm :\n";
	graph.Prim();
	cout << "Developed By:JR.Y\n";
	cout << "---> De.coder();\n";
    return 0;
}

