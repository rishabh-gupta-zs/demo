package com.zs.assignment2;

import java.util.Scanner;

public class MatrixController {

    private Scanner scanner=new Scanner(System.in);
    private MatrixService matrixService=new MatrixService();

    public void run(){

        int input;
        do{
            System.out.println("1.  Addition\n2.  Subtraction\n3.  Multiplication\n" +
                    "4.  Scalar Product\n5.  Transpose\n-1 Exit");
            input=scanner.nextInt();
            switch (input){
                case 1:
                    addition();
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    scalarProduct();
                    break;
                case 5:
                    transpose();
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }while(input!=-1);
    }

    public void addition(){
        int[][] matrix1=inputMatrix();
        int[][] matrix2=inputMatrix();
        int[][] result= matrixService.sum(matrix1,matrix2);
        System.out.print("Addition ");
        printMatrix(result);
    }

    public void subtraction(){
        int[][] matrix1=inputMatrix();
        int[][] matrix2=inputMatrix();
        int[][] result= matrixService.subtraction(matrix1,matrix2);
        System.out.print("Subtraction ");
        printMatrix(result);
    }

    public void multiplication(){
        int[][] matrix1=inputMatrix();
        int[][] matrix2=inputMatrix();
        int[][] result= matrixService.product(matrix1,matrix2);
        System.out.print("Multiplication ");
        printMatrix(result);
    }

    public void scalarProduct(){
        int[][] matrix=inputMatrix();
        System.out.println("Enter a number for scalar product");
        int number=scanner.nextInt();
        int[][] result=matrixService.scalarProduct(matrix,number);
        System.out.print("Scalar product ");
        printMatrix(result);
    }

    public void transpose(){
        int[][] matrix=inputMatrix();
        int[][] result=matrixService.transpose(matrix);
        System.out.print("Transpose ");
        printMatrix(result);
    }

    public void printMatrix(int[][] matrix){
        if(matrix==null){
            System.out.println("can not done");
            return;
        }
        System.out.println("-");
        int row= matrix.length;
        int column=matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
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
