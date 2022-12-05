package com.zs.assignment5.service;

import com.zs.assignment5.exception.LogFileException;
import com.zs.assignment5.model.LogData;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogParserService {

    private static Scanner fileReader;
    private final static ArrayList<LogData> logDataArrayList=new ArrayList<>();
    private final static Logger logger= LoggerFactory.getLogger(LogParserService.class);//uncomment

    /**
     * Converts String date into date object
     * @param dateString - date string
     * @return - date object
     */
    public Date parseDate(String dateString){
        Date date= null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (java.text.ParseException e) {
            logger.error("Invalid Date format."+dateString);
            return date;
        }
        return date;
    }

    /**
     * Extract the commit date and author name from file and store in arrayList
     * @throws LogFileException - throws when file format is incorrect or blank.
     */
    public void extractData() throws LogFileException, FileNotFoundException {

        String filePathName="src/main/resources/log.txt";
        File file=new File(filePathName);
        if(!file.exists()){
            throw new LogFileException("File not found");
        }
        else{
            fileReader=new Scanner(new File(filePathName));
        }

        if(!fileReader.hasNext()){
            throw new LogFileException("Empty File");
        }
        String line,author="";
        Date commitDate=null;

        while (fileReader.hasNext()){
            line=fileReader.nextLine();

            if(line.startsWith("Author:")){
                author = line.split(" ")[1];
                continue;
            }

            else if (line.startsWith("Date:")) {
                String[] splitDate=line.split(" ");
                if(splitDate[4].equals("Sep"))    splitDate[4]="Sept";
                String stringDate=splitDate[5]+"-"+splitDate[4]+"-"+splitDate[7];
                commitDate= parseDate(stringDate);
            }

            else continue;

            LogData logData=new LogData(author,commitDate);
            logDataArrayList.add(logData);
        }
    }



    /**
     * returns number of commit by each author
     */
    public HashMap<String,Integer> getCommitCount(Date date){

        HashMap<String,Integer> commitCount=new HashMap<>();

        for (LogData logdata:logDataArrayList){
            if(logdata.getCommitDate().before(date))
                break;

            if(commitCount.containsKey(logdata.getAuthor())){
                commitCount.put(logdata.getAuthor(),commitCount.get(logdata.getAuthor())+1);
            }
            else{
                commitCount.put(logdata.getAuthor(), 1);
            }
        }
        return commitCount;
    }

    /**
     * returns number of commit by each user each day
     */
    public HashMap<Date,HashMap<String,Integer>> getCommitCountPerDay(Date date){

        HashMap<Date,HashMap<String,Integer>> commitPerDay=new HashMap<>();
        HashMap<String,Integer> commitCountOfDay=new HashMap<>();
        Date currentdate=logDataArrayList.get(0).getCommitDate();

        for (LogData logdata:logDataArrayList){
            if(logdata.getCommitDate().before(date))
                break;
            if(currentdate.equals(logdata.getCommitDate())){
                if(commitCountOfDay.containsKey(logdata.getAuthor())){
                    commitCountOfDay.put(logdata.getAuthor(),commitCountOfDay.get(logdata.getAuthor())+1);
                }
                else{
                    commitCountOfDay.put(logdata.getAuthor(), 1);
                }
            }
            else {
                commitPerDay.put(currentdate,commitCountOfDay);
                commitCountOfDay=new HashMap<>();
                currentdate=logdata.getCommitDate();
                commitCountOfDay.put(logdata.getAuthor(), 1);
            }
        }
        commitPerDay.put(currentdate,commitCountOfDay);
        return commitPerDay;
    }

    /**
     * Returns the authors who have not committed for last 2 days
     */
    public HashSet<String> getInactiveAuthors(){

        Date before2Days=logDataArrayList.get(0).getCommitDate();
        before2Days.setDate(before2Days.getDate()-1);
        HashSet<String> inactiveDevelopers=new HashSet<>();

        for(LogData logData:logDataArrayList){
            if(logData.getCommitDate().before(before2Days)){
                inactiveDevelopers.add(logData.getAuthor());
            }
        }
        return inactiveDevelopers;
    }
}
