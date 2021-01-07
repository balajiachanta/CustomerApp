package com.customerapi.CustomerApp.com.customerapi.model;

import lombok.Data;


@Data
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
