package com.zs.assignment5.controller;

import com.zs.assignment5.exception.LogException;
import com.zs.assignment5.service.ParseService;
import org.apache.logging.log4j.core.parser.ParseException;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class ParserController {

    ParseService parseService=new ParseService();
    Scanner scanner=new Scanner(System.in);

    /**
     * Reads the file and take input task to perform
     * @param filePathName - Path of git log file
     * @param date - date after which commit frequency need to print
     */
    public void start(String filePathName, Date date){

        try {
            parseService.readFile(filePathName);
            parseService.extractDataAfter(date);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (LogException e) {
            throw new RuntimeException(e);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int input;
        do{
            System.out.println("Select------");
            System.out.printf(" 1.  Count of commit by Each developer since - %d/%d/%d%n",date.getDate(),date.getMonth(),date.getYear());
            System.out.printf(" 2.  Count of commit by Each developer per day since - %d/%d/%d%n",date.getDate(),date.getMonth(),date.getYear());
            System.out.println(" 3.  print data");
            System.out.println(" 4.  List of developer who did not commit for 2 days\n-1  Exit");
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
                    break;

                case -1:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }while (input!=-1);
    }
}
