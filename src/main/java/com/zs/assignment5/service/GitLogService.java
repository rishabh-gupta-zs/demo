package com.zs.assignment5.service;

import com.zs.assignment5.exception.LogFileException;
import com.zs.assignment5.model.LogData;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GitLogService {

    private final static ArrayList<LogData> logDataList =new ArrayList<>();
    private final SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy");

    /**
     * Extract the commit date and author name from file and store in arrayList
     * @throws LogFileException - throws when file format is incorrect or blank.
     * @throws FileNotFoundException - throws when file not found
     * @throws ParseException - throws when date format is incorrect
     */
    public void extractData() throws LogFileException, FileNotFoundException, ParseException {

        String filePathName="src/main/resources/log.txt";
        File file=new File(filePathName);
        Scanner fileReader;
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
                commitDate= simpleDateFormat.parse(stringDate);
            }

            else continue;

            LogData logData=new LogData(author,commitDate);
            logDataList.add(logData);
        }
    }



    /**
     * returns number of commit by each author
     */
    public HashMap<String,Integer> getCommitCount(Date date){

        HashMap<String,Integer> commitCount=new HashMap<>();

        for (LogData logData: logDataList){
            if(logData.getCommitDate().before(date))
                break;

            if(commitCount.containsKey(logData.getAuthor())){
                commitCount.put(logData.getAuthor(),commitCount.get(logData.getAuthor())+1);
            }
            else{
                commitCount.put(logData.getAuthor(), 1);
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
        Date currentdate= logDataList.get(0).getCommitDate();

        for (LogData logData: logDataList){
            if(logData.getCommitDate().before(date))
                break;
            if(currentdate.equals(logData.getCommitDate())){
                if(commitCountOfDay.containsKey(logData.getAuthor())){
                    commitCountOfDay.put(logData.getAuthor(),commitCountOfDay.get(logData.getAuthor())+1);
                }
                else{
                    commitCountOfDay.put(logData.getAuthor(), 1);
                }
            }
            else {
                commitPerDay.put(currentdate,commitCountOfDay);
                commitCountOfDay=new HashMap<>();
                currentdate=logData.getCommitDate();
                commitCountOfDay.put(logData.getAuthor(), 1);
            }
        }
        commitPerDay.put(currentdate,commitCountOfDay);
        return commitPerDay;
    }

    /**
     * Returns the authors who have not committed for last 2 days
     */
    public HashSet<String> getInactiveAuthors(Date date){

        Date before2Days= logDataList.get(0).getCommitDate();
        before2Days.setDate(before2Days.getDate()-1);
        HashSet<String> inactiveDevelopers=new HashSet<>();

        for(LogData logData: logDataList){
            if(logData.getCommitDate().before(date))
                break;
            if(logData.getCommitDate().before(before2Days)){
                inactiveDevelopers.add(logData.getAuthor());
            }
        }
        return inactiveDevelopers;
    }
}
