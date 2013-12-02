package com.ecoparque.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dcandelas on 18/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlInfo {

    private String ip;
    private String country_code;
    private String country_name;
    private String latitude;
    private String city;
    private String longitude;

    public String getIp() {
        return ip;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getCity() {
        return city;
    }

    public String getLongitude() {
        return longitude;
    }

}
