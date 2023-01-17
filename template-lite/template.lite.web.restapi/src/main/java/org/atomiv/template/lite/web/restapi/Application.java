package org.atomiv.template.lite.web.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * The type Application
 *
 * @author Atomiv
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("success");
//		System.out.println(args[0]);
		//		System.out.println(args[1]);
		// 		System.out.println(args[1]);

//		String customer = "hello";
//		System.out.println(customer);
//      System.out.println("" + customers.toString());


//		getNameFromRestCall();

// CURL ?? Test a REST API with curl

		getCustomers();

	}

	private static void getNameFromRestCall() {
//		final String uri = "http://localhost:8080/api/customers";
		final String uri = "http://localhost:8080/api/customers";
		// GET  localhost:8080/api/customers

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
	}

	// java command line application
	// You should implement a java rest client that call you back end spring boot api that interactes with your database. To do it you can use a lot of java rest client api.



	// call REST API command from Java
	// how to consume REST in Java
	// create REST client for Java
	private static void getCustomers() {

		try {

			URL url = new URL("http://localhost:8080/api/customers/2");//your url i.e fetch data from .
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}

	}


}
