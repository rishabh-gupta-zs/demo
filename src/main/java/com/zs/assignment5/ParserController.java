package com.zs.assignment5;

import java.io.FileNotFoundException;
import java.util.Date;

public class ParserController {

    public ParseService parseService=new ParseService();
    public void start(String filePathName, Date date){
        try {

            parseService.readFile(filePathName);
            parseService.extractData();

        } catch (LogException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
