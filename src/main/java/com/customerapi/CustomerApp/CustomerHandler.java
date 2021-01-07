package com.customerapi.CustomerApp;

import com.customerapi.CustomerApp.com.customerapi.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CustomerHandler {

    private List<Customer> customerList;

   // @PostConstruct
    public void init() throws IOException {
        String customersJsonPath = "/customers.json"; // 4 customers
        ObjectMapper mapper = new ObjectMapper();
        File customersFile = new File(customersJsonPath);
        customerList = mapper.readValue(customersFile, new TypeReference<ArrayList<Customer>>() {});
    }


    @GetMapping("/api/customers")
    public void getAllCustomers(){

       // return Collections.EMPTY_LIST;

    }
}
