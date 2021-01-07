package com.customerapi.CustomerApp;

import com.customerapi.CustomerApp.com.customerapi.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@WebMvcTest
class CustomerAppApplicationTests {

	ObjectMapper mapper;

	ArrayList<Customer> customerList;
	String customersJsonPath = "src/test/customers.json"; // 4 customers
	String customerJsonPath = "src/test/existingCustomer.json"; // 1 customer
	String newCustomerJsonPath = "src/test/newCustomer.json"; // 1 customer

	String findCustomerJsonPath = "src/test/findCustomer.json"; // 1 customer


	@BeforeEach
	void setUp() throws IOException {
		initializeCustomersData();
	}


	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllCustomers() throws Exception {

		String customersJsonPath = "src/test/customers.json"; // 4 customers
		String exceptedValue;
		ObjectMapper om = new ObjectMapper();
		exceptedValue = om.writeValueAsString(customerList);
		String actualValue = this.mockMvc.perform(get("/api/customers")).andReturn().getResponse().getContentAsString();
		assertEquals(exceptedValue,actualValue);

	}

	private void initializeCustomersData() throws IOException {
		mapper = new ObjectMapper();
		File customersFile = new File(customersJsonPath);
		customerList = mapper.readValue(customersFile, new TypeReference<ArrayList<Customer>>() {});
	}

}
