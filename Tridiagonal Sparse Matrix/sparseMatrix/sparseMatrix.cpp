// sparseMatrix.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include<iostream>
#include"TridiagonalMatrix.h"
using namespace std;

int main()
{
	cout << "Enter degree matrix :\n";
	int degreeMatrix;
	cin >> degreeMatrix;
	TridiagonalMatrix tridiagonal(degreeMatrix);
	tridiagonal.printMatrix();

	cout << "a sparse matrix is a matrix in which most of the elements are zero.\n";
	cout << "\nDeveloped By JR.Y.\n";
	cout << "----> De.Coder();\n";
    return 0;
}

