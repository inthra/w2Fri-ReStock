package com.epicodus.restock.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Foodtruck {
    String name;
    String phone;
    List<String> address = new ArrayList<>();
    double latitude;
    double longitude;
    private String pushId;

    public Foodtruck() {}

    public Foodtruck(String name, String phone, ArrayList<String> address, double latitude, double longitude) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
