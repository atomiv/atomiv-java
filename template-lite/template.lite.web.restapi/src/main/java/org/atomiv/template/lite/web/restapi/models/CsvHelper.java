package org.atomiv.template.lite.web.restapi.models;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.atomiv.template.lite.web.restapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;


public class CsvHelper {
	
//	public static String TYPE = "text/csv";
//	  static String[] HEADERs = { "Id", "First Name", "Last Name"};
//
//	  public static boolean hasCSVFormat(Customer file) {
//
//	    if (!TYPE.equals(file.getContentType())) {
//	      return false;
//	    }
//
//	    return true;
//	  }
//
//	  public static List<Customer> csvToTutorials(InputStream is) {
//	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//	        CSVParser csvParser = new CSVParser(fileReader,
//	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//	      List<Customer> tutorials = new ArrayList<Customer>();
//
//	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//	      for (CSVRecord csvRecord : csvRecords) {
//	        Customer customer = new Customer(
//	              Long.parseLong(csvRecord.get("Id")),
//	              csvRecord.get("First Name"),
//	              csvRecord.get("Last Name")
//	            );
//
//	        customers.add(customer);
//	      }
//
//	      return customers;
//	    } catch (IOException e) {
//	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//	    }
//	  }
//
//	  public static ByteArrayInputStream customersToCSV(List<Customer> customers) {
//	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
//
//	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
//	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
//	      for (Customer cusromer : customers) {
//	        List<String> data = Arrays.asList(
//	              String.valueOf(customers.getId()),
//	              customers.getFirstName(),
//	              customers.getLastName();
//	              
//	            );
//
//	        csvPrinter.printRecord(data);
//	      }
//
//	      csvPrinter.flush();
//	      return new ByteArrayInputStream(out.toByteArray());
//	    } catch (IOException e) {
//	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
//	    }
//	  }
//	
}
	


