package com.wanban.pojo;

public class Place {
    private Integer placeId;

    private String placeName;

    private String placeSports;

    private String placeLevel;

    private Double longitude;

    private Double latitude;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName == null ? null : placeName.trim();
    }

    public String getPlaceSports() {
        return placeSports;
    }

    public void setPlaceSports(String placeSports) {
        this.placeSports = placeSports == null ? null : placeSports.trim();
    }

    public String getPlaceLevel() {
        return placeLevel;
    }

    public void setPlaceLevel(String placeLevel) {
        this.placeLevel = placeLevel == null ? null : placeLevel.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}