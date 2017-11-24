package com.miguel.a02_customlist;

/**
 * Created by miguelcampos on 23/11/17.
 */

public class Student {
    private String name;
    private int age;
    private String city;
    private String photo;

    public Student(String name, int age, String city, String photo) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
