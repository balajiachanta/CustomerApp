package com.customerapi.CustomerApp;

import com.customerapi.CustomerApp.com.customerapi.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@WebMvcTest
class CustomerAppApplicationTests {

	ObjectMapper mapper;
	ArrayList<Customer> customerList;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllCustomers() throws Exception {

		String customersJsonPath = "src/test/data/customers.json"; // 4 customers


		this.mockMvc.perform(get("/api/customers")).andExpect(status().isOk());
		//mockMvc.perform().andExpect(status().isOk());


	}

	private void initializeCustomersData() throws IOException {
		mapper = new ObjectMapper();
		File customersFile = new File(customersJsonPath);
		customerList = mapper.readValue(customersFile, new TypeReference<ArrayList<Customer>>() {});
	}

}
