package com.zs.assignment5;

import com.zs.assignment5.controller.ParserController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainParser {

    public static void main(String[] args) {

        ParserController parserController=new ParserController();
        String filePathName="log.txt";

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        Date date= null;
        try {
            date = simpleDateFormat.parse("20-Dec-2020");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        parserController.start( filePathName , date );

    }
}
