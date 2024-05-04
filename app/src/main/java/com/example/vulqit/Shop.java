package com.example.vulqit;

public class Shop {
    private final int shopImage;
    private final String shopName;

    public Shop(int shopImage, String shopName) {
        this.shopImage = shopImage;
        this.shopName = shopName;
    }

    public String getShopName(){
        return shopName;
    }

    public int getShopImage(){
        return shopImage;
    }
}
