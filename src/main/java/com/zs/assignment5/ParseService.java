package com.zs.assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ParseService {

    public File file=null;
    public Scanner fileReader;
    public ArrayList<LogData> logDataArrayList=new ArrayList<>();
    public HashSet<String> authors=new HashSet<>();
    public HashMap<String,Integer> commitFrequency=new HashMap<>();


    public void readFile(String filePathName) throws LogException, FileNotFoundException {
        file=new File(filePathName);
        if(!file.exists()){
            throw new LogException("File not found");
        }
        else{
            fileReader=new Scanner(file);
        }
    }

    public void extractData() throws LogException {
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

            logDataArrayList.add(new LogData(author,commitDate));
            while (fileReader.hasNext()){
                commitLine= fileReader.nextLine();
                if(commitLine.startsWith("commit"))
                    break;
            }
        }

    }

    public String getAuthor(String authorLine) throws LogException {
        if(authorLine.startsWith("Author:"))
         return authorLine.split(" ")[1];
        else
            throw new LogException("Invalid Format");
    }

    public Date getDate(String dateLine) throws LogException {
        if(dateLine.startsWith("Date:")){
            String[] stringSplit=dateLine.split(" ");
            int month=getMonth(stringSplit[4]);
            int date=Integer.parseInt(stringSplit[5]);
            int year=Integer.parseInt(stringSplit[7]);
                return new Date(year,month,date);
        }
        else throw new LogException("Invalid format");
    }

    public int getMonth(String month) throws LogException {
        switch (month){
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
        }
        throw new LogException("Invalid date format*"+month+"*");
    }

    public void printData(){
        for(LogData data:logDataArrayList){
            System.out.println(data.author+"-->"+data.commitDate.getTime()
            );
        }
    }

    public void commitFrequencyAfter(Date date){
         for (LogData logdata:logDataArrayList){
             if(logdata.commitDate.after(date)){
                 if(commitFrequency.containsKey(logdata.author)){
                     commitFrequency.put(logdata.author,commitFrequency.get(logdata.author)+1);
                 }
                 else{
                     commitFrequency.put(logdata.author, 1);
                 }
             }
         }
         printFrequncy();
    }
    public void commitFrequencyPerdayAfter(Date date){
//        if()
        for (LogData logdata:logDataArrayList){
            if(logdata.commitDate.after(date)){
                if(commitFrequency.containsKey(logdata.author)){
                    commitFrequency.put(logdata.author,commitFrequency.get(logdata.author)+1);
                }
                else{
                    commitFrequency.put(logdata.author, 1);
                }
            }
            else {
                break;
            }
        }
        printFrequncy();
    }

    public void printFrequncy(){

        for (String author:commitFrequency.keySet()){
            System.out.println(author+" --> "+commitFrequency.get(author));
        }
    }

}
