package com.wanban.pojo;


public class FirstLevel{

    private Integer firstId;

    private String firstName;

    private String firstImageName;

    public FirstLevel(){
        super();
    }

    public FirstLevel(Integer firstId, String firstName, String firstImageName) {
        this.firstId = firstId;
        this.firstName = firstName;
        this.firstImageName = firstImageName;
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getFirstImageName() {
        return firstImageName;
    }

    public void setFirstImageName(String firstImageName) {
        this.firstImageName = firstImageName == null ? null : firstImageName.trim();
    }
}