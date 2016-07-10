package com.epicodus.restock.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Foodcart {
    private String mName;
    private String mPhone;
    private String mWebsite;
    private ArrayList<String> mAddress = new ArrayList<>();
    private double mLatitude;
    private double mLongitude;

    public Foodcart() {}

    public Foodcart(String name, String phone, String website, ArrayList<String> address, double latitude, double longitude) {
        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mAddress = address;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public ArrayList<String> getAddress() {
        return mAddress;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }
}
