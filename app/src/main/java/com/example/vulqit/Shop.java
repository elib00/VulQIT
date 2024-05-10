package com.example.vulqit;

import java.util.HashMap;

public class Shop {
    private final int shopImage;
    private final String shopName;
    private final String contactNumber;
    private final String operatingTime;
    private final String location;
    private final String plusCode;
    private final double latitude;
    private final double longitude;
    private final HashMap<String, String> service;

    public Shop(int shopImage, String shopName, String contactNumber, String operatingTime, String location, String plusCode, double latitude, double longitude, HashMap<String, String> service) {
        this.shopImage = shopImage;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
        this.operatingTime = operatingTime;
        this.location = location;
        this.plusCode = plusCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.service = service;
    }

    public String getShopName(){
        return shopName;
    }

    public int getShopImage(){
        return shopImage;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public String getLocation() {
        return location;
    }

    public String getPlusCode() {
        return plusCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public HashMap<String, String> getService(){
        return service;
    }
}
