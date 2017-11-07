package com.example.akshar.jsonparsing;

import java.io.Serializable;

/**
 * Created by Akshar on 11/4/2017.
 */

class DataModel implements Serializable{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String iconUrl;
    String lat;
    String lng;

    @Override
    public String toString() {
        return "DataModel{" + "iconUrl='" + iconUrl + '\'' + ", lat='" + lat + '\'' + ", lng='" + lng + '\'' + '}';
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
