package com.customerapi.CustomerApp.com.customerapi.model;


import lombok.Data;

@Data
public class CustomerData {

    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
}
