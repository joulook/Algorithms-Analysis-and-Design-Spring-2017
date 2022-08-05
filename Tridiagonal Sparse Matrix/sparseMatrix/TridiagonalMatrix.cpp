#include "stdafx.h"
#include "TridiagonalMatrix.h"
#include<iostream>
#include<vector>
using namespace std;

TridiagonalMatrix::TridiagonalMatrix(int degree)
{
	//cout << "In numerical analysis, a sparse matrix is a matrix in which most of the elements are zero.\n";

	degreeMatrix = degree;
	ArraySize = (degreeMatrix - 2) * 3 + 4;
	cout << "Non-zero elements of the matrix with random numbers in the range of [a,b] will be initialized. b>a \n";
	cout << "Enter a,b :\n";
	cin >> a >> b;
	while (!(b > a)) {
		cout << "Numbers entered is incorrect .b should be greater than a.\n";
		cout << "Enter a,b again:";
		cin >> a >> b;
	}
	CreateMatrix();
}
//**********************************************
void TridiagonalMatrix::CreateMatrix() {
	Array.resize(ArraySize);
	for (int i = 0; i < ArraySize; i++) {
		Array[i] = a + rand() % (b - a + 1);
	}
}
//***********************************************
int TridiagonalMatrix::Mapping(int i,int j) {
	return (2 + (i - 2) * 3 + j) ? (i > 1 && i <= degreeMatrix):(j);
}
//**********************************************
void TridiagonalMatrix::printMatrix() {
	cout << "*************************************************\n";
	for (int i = 1; i <= degreeMatrix; i++) {
		for (int j = 1; j <= degreeMatrix; j++) {
			if ((i - 1 == j) || (i == j) || (i == j - 1)) {
				print(Array[Mapping(i,j)]);
			}
			else
				print(Zero);
		}
		cout<<"\n\n";
	}
	cout << "*************************************************\n";
}
void TridiagonalMatrix::print(int num) {
	int n = num;
	int count = 1;
	while (n / 10 != 0) {
		count++;
		n /= 10;
	}
	switch (count) {
	case 1:cout << num << "      "; break;
	case 2:cout << num << "     "; break;
	case 3:cout << num << "    "; break;
	case 4:cout << num << "   "; break;
	case 5:cout << num << "  "; break;
	case 6:cout << num << " "; break;
	case 7:cout << num; break;
	default: break;
	}
}
