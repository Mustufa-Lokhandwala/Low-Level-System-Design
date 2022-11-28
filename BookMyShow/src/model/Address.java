package model;

import model.enums.City;

public class Address {
    private City city;
    private String state;
    private int pincode;
    private String detail;

    public Address(City city, String state, int pincode, String detail) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.detail = detail;
    }

    public City getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPincode() {
        return pincode;
    }

    public String getDetail() {
        return detail;
    }
}
