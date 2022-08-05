#pragma once
#include<vector>
#include<iostream>
using namespace std;

class TridiagonalMatrix
{
public:
	TridiagonalMatrix(int);
	void CreateMatrix();
	int Mapping(int,int);
	void printMatrix();
	void print(int);

private:
	int degreeMatrix;
	int ArraySize;
	vector<int>Array;
	int a; //lower bound
	int b; //upper bound
	const int Zero = 0;
};

