package com.cly.mara.bean;

import java.io.Serializable;

public class PulicationBean implements Serializable {
    private int pid;
    private String imgSrc;
    private String aName;
    private int uid;
    private int year;
    private String content;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAid() {
        return pid;
    }

    public void setAid(int pid) {
        this.pid = pid;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
