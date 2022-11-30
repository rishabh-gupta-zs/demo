package com.zs.assignment5.service;

import com.zs.assignment5.exception.LogException;
import com.zs.assignment5.model.LogData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParseService {

    Scanner fileReader;
    private ArrayList<LogData> logDataArrayList=new ArrayList<>();
    private HashMap<String,Integer> commitFrequency=new HashMap<>();
    private HashSet<String> authors=new HashSet<>();
    private Logger logger= LogManager.getLogger(ParseService.class.getName());

    /**
     * Inititialize file reader for the path and throw
     * @param filePathName - Path of file
     * @throws LogException - User defined exception
     * @throws FileNotFoundException - file not found exception
     */
    public void readFile(String filePathName) throws LogException, FileNotFoundException {

        File file=new File(filePathName);
        if(!file.exists()){
            throw new LogException("File not found");
        }
        else{
            fileReader=new Scanner(new File(filePathName));
        }
    }

    /**
     * Extract the commit date and author name from file and store in arrayList
     * @throws LogException - throws when file format is incorrect or blank.
     * @throws ParseException - Throws when input cannot parsed.
     */
    public void extractDataAfter(Date date) throws LogException, ParseException {

        if(!fileReader.hasNext()){
            throw new LogException("Empty File");
        }
        String line,dateLine,author="";
        Date commitDate=null;

        while (fileReader.hasNext()){
            line=fileReader.nextLine();
            if(line.startsWith("Author:")){
                author=getAuthor(line);
                continue;
            } else if (line.startsWith("Date:")) {
                commitDate=getDate(line);
            }
            else continue;

            if(commitDate!=null && commitDate.before(date))
                break;

            LogData logData=new LogData();
            logData.setAuthor(author);
            logData.setCommitDate(commitDate);
            logDataArrayList.add(logData);
            authors.add(author);
        }
    }

    public void printData(){
        for(LogData data : logDataArrayList)
            logger.info(data);
    }

    /**
     * Extract author name from Line.
     * @param authorLine - Line which contains author name
     * @return - Author name
     * @throws LogException - Throws when format is not valid
     */
    public String getAuthor(String authorLine) throws LogException {

        if(authorLine.startsWith("Author:"))
         return authorLine.split(" ")[1];
        else
            throw new LogException("Invalid Format");
    }

    /**
     * Extract date from Line;
     * @param dateLine - Line which contains date
     * @return - date
     * @throws ParseException - thros when input cannot parsed
     */
    public Date getDate(String dateLine) throws ParseException {

        String[] splittedDate=dateLine.split(" ");
        String stringDate=splittedDate[5]+"-"+splittedDate[4]+"-"+splittedDate[7];
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
        Date commitDate= null;

        try {
            commitDate = formatter.parse(stringDate);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
        return commitDate;
    }

    /**
     * Log number of commit by each author
     */
    public void commitFrequency(){

         for (LogData logdata:logDataArrayList){
             if(commitFrequency.containsKey(logdata.getAuthor())){
                 commitFrequency.put(logdata.getAuthor(),commitFrequency.get(logdata.getAuthor())+1);
             }
             else{
                 commitFrequency.put(logdata.getAuthor(), 1);
             }
         }

         logger.info("  Number of commit by each authore ");
         printFrequency();
         commitFrequency.clear();
    }

    /**
     * Log number of commit by each user each day
     */
    public void commitFrequencyPerday(){

        Date currentdate=logDataArrayList.get(0).getCommitDate();
        for (LogData logdata:logDataArrayList){
            if(currentdate.equals(logdata.getCommitDate())){
                if(commitFrequency.containsKey(logdata.getAuthor())){
                    commitFrequency.put(logdata.getAuthor(),commitFrequency.get(logdata.getAuthor())+1);
                }
                else{
                    commitFrequency.put(logdata.getAuthor(), 1);
                }
            }
            else {
                logger.info("--*  "+currentdate+"  *--");
                printFrequency();
                commitFrequency.clear();
                currentdate=logdata.getCommitDate();
                commitFrequency.put(logdata.getAuthor(), 1);
            }
        }
        logger.info("--*  "+currentdate+"  *--");
        printFrequency();
        commitFrequency.clear();
    }

    /**
     * Prints the authors who have not committed for last 2 days
     */
    public void printInactiveAuthors(){

        Date before2Days=logDataArrayList.get(0).getCommitDate();
        before2Days.setDate(before2Days.getDate()-1);
        HashSet<String> activeAuthors=new HashSet<>();

        for(LogData logData:logDataArrayList){
            if(logData.getCommitDate().before(before2Days)){
                break;
            }
            activeAuthors.add(logData.getAuthor());
        }

        logger.info("----* Authors Inactive From 2 Days *----");
        for (String author : authors){
            if(!activeAuthors.contains(author))
                logger.info(author);
        }
    }

    /**
     * prints the hashmap which has frequency of commit
     */
    public void printFrequency(){

        for (String author:commitFrequency.keySet()){
            logger.info("\t"+author+" --> "+commitFrequency.get(author));
        }
    }
}
