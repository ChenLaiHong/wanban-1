package com.wanban.pojo;

import java.util.Date;

public class Releases {
    private Integer releaseId;

    private Date releaseTime;

    private Date sportTime;

    private String sportPlace;

    private String types;

    private Integer status;

    private Integer userId;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types == null ? null : types.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}