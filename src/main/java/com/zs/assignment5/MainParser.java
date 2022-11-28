package com.zs.assignment5;

import java.io.File;
import java.util.Date;

public class MainParser {
    public static void main(String[] args) {

        ParserController parserController=new ParserController();
        String filePathName="log.txt";
        Date date=new Date(2022,10,8);    //yyyy,mm,dd
        parserController.start( filePathName , date );

    }
}
