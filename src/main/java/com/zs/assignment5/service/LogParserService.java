package com.zs.assignment5.service;

import com.zs.assignment5.exception.LogException;
import com.zs.assignment5.model.LogData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParserService {

    private Scanner fileReader;
    private ArrayList<LogData> logDataArrayList=new ArrayList<>();
    private HashSet<String> authors=new HashSet<>();
    private Logger logger= LoggerFactory.getLogger(LogParserService.class);

    public Date getDate(String dateString){

        Date date= null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (java.text.ParseException e) {
            logger.error("Invalid Date format.");
            return date;
        }
        return date;
    }

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
     */
    public void extractData() throws LogException{

        if(!fileReader.hasNext()){
            throw new LogException("Empty File");
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
                String stringDate=splitDate[5]+"-"+splitDate[4]+"-"+splitDate[7];
                commitDate=getDate(stringDate);
            }

            else continue;

            LogData logData=new LogData(author,commitDate);
            logDataArrayList.add(logData);
            authors.add(author);
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

        HashMap<Date,HashMap<String,Integer>> commitPerday=new HashMap<>();
        HashMap<String,Integer> commitCountOfDay=new HashMap<>();
        Date currentdate=logDataArrayList.get(0).getCommitDate();

        for (LogData logdata:logDataArrayList){
            if(currentdate.equals(logdata.getCommitDate())){
                if(commitCountOfDay.containsKey(logdata.getAuthor())){
                    commitCountOfDay.put(logdata.getAuthor(),commitCountOfDay.get(logdata.getAuthor())+1);
                }
                else{
                    commitCountOfDay.put(logdata.getAuthor(), 1);
                }
            }
            else {
                commitPerday.put(currentdate,commitCountOfDay);
                commitCountOfDay.clear();
                currentdate=logdata.getCommitDate();
                commitCountOfDay.put(logdata.getAuthor(), 1);
            }
        }
        commitPerday.put(currentdate,commitCountOfDay);
        return commitPerday;
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
