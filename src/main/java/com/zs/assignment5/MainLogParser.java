package com.zs.assignment5;

import com.zs.assignment5.controller.LogParserController;

public class MainLogParser {

    public static void main(String[] args) {

        LogParserController parserController=new LogParserController();
        String filePathName="src/main/resources/log.txt";
        parserController.start( filePathName );

    }
}
