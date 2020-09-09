package org.atomiv.template.lite.web.restapi.dto;

import java.util.ArrayList;
import java.util.List;



public class CustomerClientApp {

	List<CustomerDto> customers = new ArrayList<>();
	CustomerDto customerOne = new CustomerDto(1, "Petar", "Petrovic");
	CustomerDto customerTwo = new CustomerDto(2, "Ana", "Jovic");
//	customers.add(customerOne);
//	customers.add(customerTwo);
	
	CustomerResource customerResource = new CustomerResource(customers);
}
