package com.zs.assignment2;

import java.util.Scanner;

public class MatrixController {

    public static Scanner scanner=new Scanner(System.in);
    public void run(){
        MatrixService matrixServices=new MatrixService();
        int[][] matrix1=inputMatrix();
        int[][] matrix2=inputMatrix();

        System.out.println("Matrix 1 is-");
        printMatrix(matrix1);
        System.out.println("Matrix 2 is-");
        printMatrix(matrix2);

        int[][] sum=matrixServices.sum(matrix1,matrix2);
        if(sum==null){
            System.out.println("Sum is not possible for these matrices");
        }
        else{
            System.out.println("Sum of matrices is-");
            printMatrix(sum);
        }

        int[][] subtraction=matrixServices.subtraction(matrix1,matrix2);
        if(subtraction==null){
            System.out.println("subtraction is not possible for these matrices");
        }
        else{
            System.out.println("Subtraction of matrices is-");
            printMatrix(subtraction);
        }

        int[][] product=matrixServices.product(matrix1,matrix2);
        if(product==null){
            System.out.println("Product is not possible for these matrices");
        }
        else{
            System.out.println("Product of matrices is-");
            printMatrix(product);
        }

        System.out.println("Enter a number for scalar product");
        int number=scanner.nextInt();
        int[][] scalarProduct1=matrixServices.scalarProduct(matrix1,number);
        System.out.println("Scalar product of first matrix with "+number+" is");
        printMatrix(scalarProduct1);

        int[][] scalarProduct2=matrixServices.scalarProduct(matrix2,number);
        System.out.println("Scalar product of second matrix with "+number+" is");
        printMatrix(scalarProduct2);

        int[][] transpose1= matrixServices.transpose(matrix1);
        System.out.println("Transpose of first matrix is");
        printMatrix(transpose1);

        int[][] transpose2= matrixServices.transpose(matrix2);
        System.out.println("Transpose of second matrix is");
        printMatrix(transpose2);
    }

    public void printMatrix(int[][] matrix){
        int row= matrix.length;
        int column=matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public int[][] inputMatrix(){
        System.out.println("Enter number of rows and column in matrix");
        int row= scanner.nextInt();
        int column= scanner.nextInt();
        System.out.println("Enter elements of matrix");
        int matrix[][]=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                matrix[i][j]= scanner.nextInt();
            }
        }
        return matrix;
    }
}
