package org.atomiv.template.lite.web.restapi;

import org.atomiv.template.lite.web.restapi.controllers.ProductsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private ProductsController productsController;

	@Test
	void contextLoads() throws Exception {
//		assertThat(productsController).isNotNull();
		assertNotNull(productsController);
	}


}
