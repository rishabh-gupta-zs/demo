package com.zs.assignment5;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class ParserController {

    public ParseService parseService=new ParseService();
    Scanner scanner=new Scanner(System.in);
    public void start(String filePathName, Date date){

        try {
            parseService.readFile(filePathName);
            parseService.extractData();
            parseService.printData();
        } catch (LogException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int input;
        do{
            System.out.println("Select------");
            System.out.printf(" 1.  Count of commit by Each developer since - %d/%d/%d%n",date.getDate(),date.getMonth(),date.getYear());
            System.out.printf(" 2.  Count of commit by Each developer per day since - %d/%d/%d%n",date.getDate(),date.getMonth(),date.getYear());
            System.out.println(" 3.  List of developer who did not commit for 2 days\n-1  Exit");
            input=scanner.nextInt();
            switch (input){
                case 1:
                    parseService.commitFrequencyAfter(date);
                    break;
                case 2:
                    break;
                case 3:
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
