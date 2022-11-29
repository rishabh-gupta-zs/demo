package com.zs.assignment5.model;

import java.util.Date;

public class LogData {
    private String author;
    private Date commitDate;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }
}
