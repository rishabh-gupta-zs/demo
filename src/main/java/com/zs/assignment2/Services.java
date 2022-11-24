package com.zs.assignment2;

public class Services {
    public void printmat(int[][] mat){
        int row= mat.length;
        int col=mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public void printSum(int[][] mat1,int[][] mat2){
        if(mat1.length!=mat2.length || mat1[0].length!=mat2[0].length){
            System.out.println("Addition cannot perform");
            return;
        }
        System.out.println("sum of mat is");
        int[][] sum=new int[mat1.length][mat1[0].length];
        int row= mat1.length;
        int col=mat1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        printmat(sum);
    }
    public void printSubstraction(int[][] mat1,int[][] mat2){
        if(mat1.length!=mat2.length || mat1[0].length!=mat2[0].length){
            System.out.println("substraction cannot perform");
            return;
        }
        System.out.println("substraction of matrix is");
        int[][] subs=new int[mat1.length][mat1[0].length];
        int row= mat1.length;
        int col=mat1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                subs[i][j]=mat1[i][j]-mat2[i][j];
            }
        }
        printmat(subs);
    }
    public void printProduct(int a[][],int b[][]) {
        if(a[0].length!=b.length){
            System.out.println("multiplication is not possible");
            return;
        }
        System.out.println("multiplication of matrix is");
        int row1=a.length;
        int col2=b[0].length;
        int col1=b.length;
        int c[][]=new int[a.length][b[0].length];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                c[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        printmat(c);
    }
    public void printScalarProduct(int[][] mat1,int k){
        int[][] scpr=new int[mat1.length][mat1[0].length];
        int row= mat1.length;
        int col=mat1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                scpr[i][j]=mat1[i][j]*k;
            }
        }
        printmat(scpr);
    }
    public void printTranspose(int[][] mat){
        int row= mat.length;
        int col=mat[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println("");
        }
    }
}
