package com.bridgezlab;

import com.opencsv.bean.CsvBindByName;

public class CsvInfo {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCountry() {
        return country;
    }
}



