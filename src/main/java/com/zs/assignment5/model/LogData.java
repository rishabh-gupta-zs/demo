package com.zs.assignment5.model;

import java.util.Date;

public class LogData {
    private String author;
    private Date commitDate;

    public LogData(String author, Date commitDate) {
        this.author = author;
        this.commitDate = commitDate;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    @Override
    public String toString() {
        return "LogData{" +
                "author='" + author + '\'' +
                ", commitDate=" + commitDate +
                '}';
    }
}
