package com.jorgegilcavazos.nuevoleontravel;

public class PlaceOfInterest {
    private String name;
    private String address;
    private String phone;
    private int rating;
    private String schedule;
    private String category;

    public PlaceOfInterest(String name, String address, String phone, int rating, String schedule,
                           String category) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
        this.schedule = schedule;
        this.category = category;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
