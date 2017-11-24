package com.miguel.a03_restaurants;

/**
 * Created by miguelcampos on 24/11/17.
 */

class Restaurant {
    private String name;
    private String address;
    private String phoneNumber;
    private int rate;
    private String website;
    private String photo;

    public Restaurant(String name, String address, String phoneNumber, int rate, String website, String photo) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rate = rate;
        this.website = website;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
