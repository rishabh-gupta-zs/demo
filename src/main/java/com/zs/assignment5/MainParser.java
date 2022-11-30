package com.zs.assignment5;

import com.zs.assignment5.controller.ParserController;

public class MainParser {

    public static void main(String[] args) {

        ParserController parserController=new ParserController();
        String filePathName="log.txt";
        parserController.start( filePathName );

    }
}
