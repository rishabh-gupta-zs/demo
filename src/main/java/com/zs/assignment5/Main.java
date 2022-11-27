//package com.zs.assignment5;
//
//import java.awt.color.ICC_ColorSpace;
//import java.io.File;
//import java.util.*;
//
//class CustomException extends Exception {
//    String message;
//    CustomException(String str) {
//        message = str;
//    }
//    public String toString() {
//        return ("Custom Exception Occurred : " + message);
//    }
//}
//
//
//public class Main {
//    public static void main(String[] args) throws Exception{
//        // pass the path to the file as a parameter
//        try {
//            File file = new File("/home/raryamuri/IdeaProjects/java-assignments/src/main/java/com/zs/assignment5/gitlog.txt");
//
//            Scanner sc = new Scanner(file);
//            boolean flag=false;
//
//            while (sc.hasNextLine()){
//                String word1=sc.next();
//                sc.next();
//                String word2=sc.next();
//                sc.next();
//                String word3=sc.next();
//
//
//                System.out.println(word1+ " " +  word2+ " " + word3);
//
//                break;
//            }
//
//
//            if((word1!="commit") || (word2!="Author:") || (word3!="Date:")  ){
//                throw new CustomException("Format Not Matched");
//            }
//
//
//        }catch(Exception e) {
//            throw new CustomException("No File Exception");
//
//        }
//
//
//
//    }
//}