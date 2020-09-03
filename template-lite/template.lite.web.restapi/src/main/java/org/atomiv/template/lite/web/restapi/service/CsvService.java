package org.atomiv.template.lite.web.restapi.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.atomiv.template.lite.web.restapi.models.CsvHelper;
import org.atomiv.template.lite.web.restapi.models.Customer;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CsvService {
	
//	 @Autowired
//	 private CustomerRepository customerRepository;
//
//	  public void save(MultipartFile file) {
//	    try {
//	      List<Customer> customers = CsvHelper.csvToTutorials(file.getInputStream());
//	      customerRepository.saveAll(customers);
//	    } catch (IOException e) {
//	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
//	    }
//	  }
//
//	  public ByteArrayInputStream load() {
//	    List<Customer> customers = customerRepository.findAll();
//
//	    ByteArrayInputStream in = CsvHelper.customersToCSV(customers);
//	    return in;
//	  }
//
//	  public List<Customer> getAllTutorials() {
//	    return customerRepository.findAll();
//	  }
	}


