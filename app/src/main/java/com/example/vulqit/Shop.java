package com.example.vulqit;

public class Shop {
    private final int shopImage;
    private final String shopName;
    private final String contactNumber;
    private final String operatingTime;
    private final String location;
    private final String plusCode;
    private final double latitude;
    private final double longitude;

    public Shop(int shopImage, String shopName, String contactNumber, String operatingTime, String location, String plusCode, double latitude, double longitude) {
        this.shopImage = shopImage;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
        this.operatingTime = operatingTime;
        this.location = location;
        this.plusCode = plusCode;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
