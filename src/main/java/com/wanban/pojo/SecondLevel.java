package com.wanban.pojo;


public class SecondLevel {

    private Integer secondId;

    private String secondName;

    private String secondImageName;

    private Integer firstId;

    private FirstLevel firstLevel;

    public FirstLevel getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(FirstLevel firstLevel) {
        this.firstLevel = firstLevel;
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName == null ? null : secondName.trim();
    }

    public String getSecondImageName() {
        return secondImageName;
    }

    public void setSecondImageName(String secondImageName) {
        this.secondImageName = secondImageName == null ? null : secondImageName.trim();
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }
}