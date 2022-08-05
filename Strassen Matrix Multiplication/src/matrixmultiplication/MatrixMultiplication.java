
package matrixmultiplication;

import java.util.Scanner;


public class MatrixMultiplication {

    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        
       int [][]A={ {261,262,263,264,265,266,267,268},
                   {273,274,275,276,277,278,279,280},
                   {285,286,287,288,289,290,291,292},
                   {297,298,299,300,301,302,303,304},
                   {309,310,311,312,313,314,315,316},
                   {321,322,323,324,325,326,327,328},
                   {333,334,335,336,337,338,339,340},
                   {345,346,347,348,349,350,351,352},
                   };
       
      int [][]B={{10,11,12,13,14,15,16,17},
                 {19,20,21,22,23,24,25,26},
                 {28,29,30,31,32,33,34,35},
                 {37,38,39,40,41,42,43,44},
                 {46,47,48,49,50,51,52,53},
                 {55,56,57,58,59,60,61,62},
                 {64,65,66,67,68,69,70,71},
                 {73,74,75,76,77,78,79,80}};
      
       int size=MatrixSize_powerOf2(A,B);
        int [][] a=new int [size][size];
        int [][] b=new int [size][size];
        copy_Matrix(A, a);
        copy_Matrix(B, b);
        
        System.out.println("\nwith Strassen algorithm :\n");
        print(Strassen_Multiply(a, b));
        System.out.println("-------------------------------------------------------------"
                + "--\n\nwith regular multipy :\n");
        print(Regular_multiply(a, b));
        
        System.out.println("\ndesign and analysis of algorithms .");
        System.out.println("divide and conquer strategy");
        System.out.println("----->>> De.coder();");
    }
    public static int[][] createMatrix(int row,int column){
        int A[][]=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                A[i][j]=(int)(Math.random()*100);
            }
        }
        return A;
    }
    public static int[][] sum(int A[][],int B[][]){
        // The matrices  are square 
        int size=A.length;
        int [][]C=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                C[i][j]=A[i][j]+B[i][j];
            }
        }
        return C;
    }
    public static int[][] subtract(int A[][],int B[][]){
        int size=A.length;
        int [][]C=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                C[i][j]=A[i][j]-B[i][j];
            }
        }
        return C;
    }
    public static void copy_Matrix(int A[][],int a[][]){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                a[i][j]=A[i][j];
            }
        }
    }
    public static void divide(int A[][],int a[][],int row,int column){
        for(int i_a=0,i_A=row;i_a<a.length;i_a++,i_A++){
            for(int j_a=0,j_A=column;j_a<a.length;j_a++,j_A++){
                a[i_a][j_a]=A[i_A][j_A];
            }
        }
    }
    public static void merge(int A[][],int a[][],int row,int column){
        for(int i_a=0,i_A=row;i_a<a.length;i_a++,i_A++){
            for(int j_a=0,j_A=column;j_a<a.length;j_a++,j_A++){
                A[i_A][j_A]=a[i_a][j_a];
            }
        }
    }
    public static  int[][] Regular_multiply(int A[][],int B[][]){
            int row=A.length;
            int column=B[0].length;
            int [][]C=new int[row][column];
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    C[i][j]=0;
                    for(int k=0;k<A[0].length;k++){
                        C[i][j]+=A[i][k]*B[k][j];
                    }
                }
            }
            return C;        
    }
    public static  int[][] Strassen_Multiply(int A[][],int B[][]){
            int n=A.length;
            int [][]c=new int[n][n];
            if(n==1){
                c[0][0]=A[0][0]*B[0][0];
                return c ;
            }
            else{
                int [][]A11=new int [n/2][n/2];
                int [][]A12=new int [n/2][n/2];
                int [][]A21=new int [n/2][n/2];
                int [][]A22=new int [n/2][n/2];
                
               
                int [][]B11=new int [n/2][n/2];
                int [][]B12=new int [n/2][n/2];
                int [][]B21=new int [n/2][n/2];
                int [][]B22=new int [n/2][n/2];
                
                //divide Matrix a to submatrices
                divide(A,A11,0,0);
                divide(A,A12,0,n/2);
                divide(A,A21,n/2,0);
                divide(A,A22,n/2,n/2);
                
                
                
                
                divide(B,B11,0,0);
                divide(B,B12,0,n/2);
                divide(B,B21,n/2,0);
                divide(B,B22,n/2,n/2);
                
                
                int [][]M1=Strassen_Multiply(sum(A11,A22),sum(B11,B22));
                int [][]M2=Strassen_Multiply(sum(A21,A22),B11);
                int [][]M3=Strassen_Multiply(A11,subtract(B12,B22));
                int [][]M4=Strassen_Multiply(A22,subtract(B21,B11));
                int [][]M5=Strassen_Multiply(sum(A11,A12),B22);
                int [][]M6=Strassen_Multiply(subtract(A21,A11),sum(B11,B12));
                int [][]M7=Strassen_Multiply(subtract(A12,A22),sum(B21,B22));
                
                int [][]C11=sum(subtract(sum(M1,M4),M5),M7);
                int [][]C12=sum(M3,M5);
                int [][]C21=sum(M2,M4);
                int [][]C22=sum(subtract(sum(M1,M3),M2),M6);
                
                
                merge(c,C11,0,0);
                merge(c,C12,0,n/2);
                merge(c,C21,n/2,0);
                merge(c,C22,n/2,n/2);
                return c;
            }
    }
    public static int MatrixSize_powerOf2(int A[][],int B[][]){
        int p=A.length; // The First matrix row
        int q=A[0].length; // The first matrix column or The second matrix row
        int r=B[0].length; // The second matrix column
        int max=(p>q)?p:q;
        max=(max>r)?max:r;
        int c=1;
        while(c<max){
            c*=2;
        }
        // size of matrix should be a power of 2 
        return c;
    }
    public static void print(int A[][]){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    
    
    
}
