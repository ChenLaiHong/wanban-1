package com.wanban.pojo;

import java.util.Date;

public class Releases {
    private Integer releaseId;

    private Date releaseTime;

    private Date sportTime;

    private String sportPlace;

    private String type;

    private Integer userId;

    public Integer getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getSportTime() {
        return sportTime;
    }

    public void setSportTime(Date sportTime) {
        this.sportTime = sportTime;
    }

    public String getSportPlace() {
        return sportPlace;
    }

    public void setSportPlace(String sportPlace) {
        this.sportPlace = sportPlace == null ? null : sportPlace.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}