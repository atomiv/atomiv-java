package org.atomiv.template.lite.web.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Application
 *
 * @author Atomiv
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("customer");
//		String customer = "hello";
//		System.out.println(customer);
//      System.out.println("" + customers.toString());
	}

}
