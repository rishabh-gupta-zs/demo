package com.zs.assignment2;

import java.util.Scanner;

public class Controller {
    public static Scanner sc=new Scanner(System.in);

    public int[][] inputMatrix(){
        System.out.println("Enter number of rows and column in matrix");
        int r= sc.nextInt();
        int c= sc.nextInt();
        System.out.println("Enter elements of matrix");
        int mat[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j]= sc.nextInt();
            }
        }
        return mat;
    }
    public int inputnum(){
        System.out.println("Enter an integer");
        return sc.nextInt();
    }
}
