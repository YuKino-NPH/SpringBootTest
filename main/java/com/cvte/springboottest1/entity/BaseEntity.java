package com.cvte.springboottest1.entity;

import java.sql.Date;

public class BaseEntity {
    private String crtUser;
    private String crtName;
    private String crtHost;
    private Date crtTime;
    private String updUser;
    private String updName;
    private String updHost;
    private Date updTime;

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getCrtName() {
        return crtName;
    }

    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    public String getCrtHost() {
        return crtHost;
    }

    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public String getUpdName() {
        return updName;
    }

    public void setUpdName(String updName) {
        this.updName = updName;
    }

    public String getUpdHost() {
        return updHost;
    }

    public void setUpdHost(String updHost) {
        this.updHost = updHost;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "crtUser='" + crtUser + '\'' +
                ", crtName='" + crtName + '\'' +
                ", crtHost='" + crtHost + '\'' +
                ", crtTime=" + crtTime +
                ", updUser='" + updUser + '\'' +
                ", updName='" + updName + '\'' +
                ", updHost='" + updHost + '\'' +
                ", updTime=" + updTime +
                '}';
    }
}
