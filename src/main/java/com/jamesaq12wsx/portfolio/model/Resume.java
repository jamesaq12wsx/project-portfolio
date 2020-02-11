package com.jamesaq12wsx.portfolio.model;

public class Resume {

    private String firstname;

    private String lastname;

    private String address;

    private String city;

    private String state;

    private String zipcode;

    public Resume() {
    }

    public Resume(String firstname, String lastname, String address, String city, String state, String zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
