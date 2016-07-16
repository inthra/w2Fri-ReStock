package com.epicodus.restock.models;

import java.util.List;

public class User {
    String username;
    String email;
    String firstname;
    String lastname;
    List<String> foodtruckId;

    public User() {}

    public User(String firstname, String lastname, String username, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getFoodtruckId() {
        return foodtruckId;
    }
}
