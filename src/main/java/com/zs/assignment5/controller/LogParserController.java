package com.zs.assignment5.controller;

import com.zs.assignment5.exception.LogFileException;
import com.zs.assignment5.service.LogParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LogParserController {

    private final LogParserService parseService=new LogParserService();
    private final Scanner scanner=new Scanner(System.in);
    private final Logger logger=LoggerFactory.getLogger(LogParserController.class);

    /**
     * Reads the file and take input task to perform
     */
    public void start(){

        try {
            parseService.extractData();

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);

        } catch (LogFileException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

        Date date=inputDate();
        int input;
        do{
            logger.info("\n--- Select ---"+
                    "\n 1.  Count of commit by Each developer since - "+date+
                    "\n 2.  Count of commit by Each developer per day since - "+date+
                    "\n 3.  List of developer who did not commit since 2 days"+date+
                    "\n 4.  Proceed with another date\n-1  Exit");
            input=scanner.nextInt();
            switch (input){
                case 1:
                    HashMap<String,Integer> commitCount=parseService.getCommitCount(date);
                    for (String key:commitCount.keySet()){
                        System.out.println(key + " ---> " + commitCount.get(key));
                    }
                    break;

                case 2:
                    HashMap<Date,HashMap<String,Integer>> commitCountPerDay=parseService.getCommitCountPerDay(date);
                    for (Date currentDate:commitCountPerDay.keySet()){
                        logger.info("-----> " + currentDate.toString() + " <-------");
                        for (String author: commitCountPerDay.get(currentDate).keySet()){
                            logger.info(author + "----> " + commitCountPerDay.get(currentDate).get(author));
                        }
                    }
                    break;

                case 3:
                    HashSet<String> inactiveDevelopers=parseService.getInactiveAuthors();
                    for (String inactiveDeveloper:inactiveDevelopers){
                        logger.info(inactiveDeveloper);
                    }
                    break;

                case 4:
                    scanner.nextLine();
                    date=inputDate();
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

    /**
     * input date from user
     * @return - date
     */
    public Date inputDate(){
        Date date=null;
        boolean repeat=true;
        while (repeat){
            repeat=false;
            System.out.println("Enter a date (dd-MMMM-yyyy)\n\t\tEg. 30-Jan-2022");
            date=parseService.parseDate(scanner.nextLine());
            if (date==null){
                repeat=true;
            }
        }
        return date;
    }
}
