package com.customerapi.CustomerApp.com.customerapi.model;

import lombok.Data;


@Data
public class Customer {
    private String status;
    private String statusCode;
    private CustomerData data;
}
