package com.zs.assignment2;

public class Main {
    public static void main(String[] args) {
        Controller ctrl=new Controller();
        Services srvc=new Services();
        int[][] mat1=ctrl.inputMatrix();
        int[][] mat2=ctrl.inputMatrix();

        System.out.println("Matrix 1 is-");
        srvc.printmat(mat1);
        System.out.println("Matrix 2 is-");
        srvc.printmat(mat2);

        srvc.printSum(mat1,mat2);
        srvc.printSubstraction(mat1,mat2);
        srvc.printProduct(mat1,mat2);

        int k=ctrl.inputnum();
        System.out.println("Scalar product of first matrix with "+k+" is");
        srvc.printScalarProduct(mat1,k);
        System.out.println("Scalar product of second matrix with "+k+" is");
        srvc.printScalarProduct(mat2,k);

        System.out.println("Transpose of first matrix is");
        srvc.printTranspose(mat1);
        System.out.println("Transpose of second matrix is");
        srvc.printTranspose(mat2);

    }
}
