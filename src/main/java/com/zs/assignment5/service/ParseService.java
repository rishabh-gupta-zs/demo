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
    private HashSet<String> authors=new HashSet<>();
    private HashMap<String,Integer> commitFrequency=new HashMap<>();
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
    public void extractData() throws LogException, ParseException {

        if(!fileReader.hasNext()){
            throw new LogException("Empty File");
        }

        String commitLine,authorLine,dateLine,author;
        Date commitDate;

        boolean flag=fileReader.nextLine().startsWith("commit");
        if(!flag){
            throw new LogException("Invalid format");
        }

        while (fileReader.hasNext()){
            authorLine=fileReader.nextLine();
            author=getAuthor(authorLine);
            authors.add(author);

            dateLine=fileReader.nextLine();
            commitDate=getDate(dateLine);

            LogData logData=new LogData();
            logData.setAuthor(author);
            logData.setCommitDate(commitDate);
            logDataArrayList.add(logData);

            while (fileReader.hasNext()){
                commitLine= fileReader.nextLine();
                if(commitLine.startsWith("commit"))
                    break;
            }
        }
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
     * Log number of commit by each user after given date
     * @param date - date
     */
    public void commitFrequencyAfter(Date date){

         for (LogData logdata:logDataArrayList){
             if(logdata.getCommitDate().before(date)){
                 break;
             }
             if(commitFrequency.containsKey(logdata.getAuthor())){
                 commitFrequency.put(logdata.getAuthor(),commitFrequency.get(logdata.getAuthor())+1);
             }
             else{
                 commitFrequency.put(logdata.getAuthor(), 1);
             }
         }
         printFrequncy();
         commitFrequency.clear();
    }

    /**
     * Log number of commit by each user each day after given date
     * @param date
     */
    public void commitFrequencyPerdayAfter(Date date){

        Date currentdate=logDataArrayList.get(0).getCommitDate();
        for (LogData logdata:logDataArrayList){
            if(logdata.getCommitDate().before(date)){
                break;
            }
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
                printFrequncy();
                commitFrequency.clear();
                currentdate=logdata.getCommitDate();
            }
        }
        logger.info("--*  "+currentdate+"  *--");
        printFrequncy();
        commitFrequency.clear();
    }

    /**
     * prints the hashmap which has frequency of commit
     */
    public void printFrequncy(){

        for (String author:commitFrequency.keySet()){
            logger.info("\t"+author+" --> "+commitFrequency.get(author)+"\n");
        }
    }

}
