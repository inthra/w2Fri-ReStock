package com.epicodus.restock.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class item {
    String name;
    int quantity;
    String unit;
    List<String> foodtruckIds = new ArrayList<>();

    public item() {}

    public item(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public List<String> getFoodtruckId() {
        return foodtruckIds;
    }

    public void setFoodtruckId(String pushId) {
        this.foodtruckIds.add(pushId);
    }
}
