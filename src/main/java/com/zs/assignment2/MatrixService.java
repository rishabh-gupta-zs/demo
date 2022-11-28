package com.zs.assignment2;

public class MatrixService {

    public int[][] sum(int[][] matrix1,int[][] matrix2){
        if(matrix1.length!=matrix2.length || matrix1[0].length!=matrix2[0].length){
            return null;
        }
        int[][] sum=new int[matrix1.length][matrix1[0].length];
        int row= matrix1.length;
        int column=matrix1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum[i][j]=matrix1[i][j]+matrix2[i][j];
            }
        }
        return sum;
    }

    public int[][] subtraction(int[][] matrix1,int[][] matrix2){
        if(matrix1.length!=matrix2.length || matrix1[0].length!=matrix2[0].length){
            return null;
        }
        int[][] subtraction=new int[matrix1.length][matrix1[0].length];
        int row= matrix1.length;
        int column=matrix1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                subtraction[i][j]=matrix1[i][j]-matrix2[i][j];
            }
        }
        return subtraction;
    }

    public int[][] product(int matrix1[][],int matrix2[][]) {
        if(matrix1[0].length!=matrix2.length){
            return null;
        }
        int row1=matrix1.length;
        int column2=matrix2[0].length;
        int column1=matrix2.length;
        int product[][]=new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                product[i][j] = 0;
                for (int k = 0; k < column1; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return product;
    }

    public int[][] scalarProduct(int[][] matrix1,int number){
        int[][] scalarProduct=new int[matrix1.length][matrix1[0].length];
        int row= matrix1.length;
        int column=matrix1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                scalarProduct[i][j]=matrix1[i][j]*number;
            }
        }
        return scalarProduct;
    }

    public int[][] transpose(int[][] matrix){
        int row= matrix.length;
        int column=matrix[0].length;
        int[][] transpose=new int[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                transpose[i][j]=matrix[j][i];
            }
        }
        return transpose;
    }
}
