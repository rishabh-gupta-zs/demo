package com.zs.assignment5.controller;

import com.zs.assignment5.exception.LogException;
import com.zs.assignment5.service.ParseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.parser.ParseException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ParserController {

    ParseService parseService=new ParseService();
    Scanner scanner=new Scanner(System.in);
    private Logger logger= LogManager.getLogger(ParseService.class.getName());


    /**
     * Reads the file and take input task to perform
     * @param filePathName - Path of git log file
     */
    public void start(String filePathName){

        logger.info("Enter date after which you want commit frequency (dd-MMM-yyyy)");
        String dateString=scanner.nextLine();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        Date date= null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (java.text.ParseException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }

        try {
            parseService.readFile(filePathName);
            parseService.extractDataAfter(date);

        } catch (FileNotFoundException e) {
            logger.error(e);
            throw new RuntimeException(e);

        } catch (LogException e) {
            logger.error(e);
            throw new RuntimeException(e);

        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }

        int input;
        do{
            logger.info("\n--- Select ---"+
                    "\n 1.  Count of commit by Each developer since - "+date+
                    "\n 2.  Count of commit by Each developer per day since - "+date+
                    "\n 3.  print data"+
                    "\n 4.  List of developer who did not commit since 2 days\n-1  Exit");
            input=scanner.nextInt();

            switch (input){
                case 1:
                    parseService.commitFrequency();
                    break;

                case 2:
                    parseService.commitFrequencyPerday();
                    break;

                case 3:
                    parseService.printData();
                    break;

                case 4:
                    parseService.printInactiveAuthors();
                    break;

                case -1:
                    logger.info("Exit.");
                    break;

                default:
                    logger.info("Invalid Selection");
                    break;
            }
        }while (input!=-1);
    }
}
