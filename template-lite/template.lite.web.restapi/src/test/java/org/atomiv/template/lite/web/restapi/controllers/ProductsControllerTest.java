package org.atomiv.template.lite.web.restapi.controllers;

import org.atomiv.template.lite.web.restapi.Calculator;
import org.atomiv.template.lite.web.restapi.models.Product;
import org.atomiv.template.lite.web.restapi.repositories.ProductRepository;
import org.atomiv.template.lite.web.restapi.services.ProductService;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;

// added
import static org.assertj.core.api.Assertions.assertThat;


 // @RunWith(SpringRunner.class) // WARNING: Runner org.junit.internal.runners.ErrorReportingRunner (used on class org.atomiv.template.lite.web.restapi.controllers.ProductsControllerTest) does not support filtering and will therefore be run completely.

@SpringBootTest // getProducts fails without this
//@AutoConfigureMockMvc
//@WithMockUser
public class ProductsControllerTest {

    // necessary???
//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    private final Calculator calculator = new Calculator();

    private Product product;


    @BeforeClass
    public void setUpClass() throws Exception {
//        assertNotNull(productRepository);
//        var fruit = new Product(1, "fruit", "2021-02-10T14:48:49.9519098");
    }

    @Before
    public void setUp() {
        var firstArrival = new Product(); // var product
        firstArrival.setId(1L);
        firstArrival.setName("pomegrane");
    }


    @Test
    @DisplayName("get products assertions")
    // public void whenFindAll() {
    public void getAllProducts() throws Exception {
        var found = productService.getAllProducts(); // var arrivals

        Product arrival2 = new Product(); // var firstArrival
        arrival2.setName("pomegrane");
//        entityManager.persist(found2);
//        entityManager.flush();

        assertNotNull(found);
        assertEquals(1, found.getRecords().size());

        assertEquals("org.atomiv.template.lite.web.restapi.dtos.product.GetAllProductsResponse", found.getClass().getName());

        assertEquals("pomegrane", found.getRecords().get(0).getName());
//        assertEquals("pomegrane", found.get(0).getName());

        assertEquals("pomegrane", arrival2.getName());
//        assertEquals("pomegrane", firstArrival.getName());



        assertThat(found.getRecords().size()).isEqualTo(1);
        assertThat(found.getRecords().get(0).getName()).isEqualTo(arrival2.getName());



    }
    //Actual   :GetAllProductsResponse(records=[GetAllProductsRecordResponse(id=1, name=pomegrane, lastModified=2021-02-10T14:48:49.951910)])


    @Test
    // public void whenFindAllById() {
    public void getProductById() {
        // given - - -
        var arrival = new Product();
        arrival.setId(1L);
        arrival.setName("pomegrane");

        // when - - -
//        var testArrival = productRepository.findById(arrival.getId()); //or findAllById??
//        var testArrival = productRepository.findById(1L);
        var testArrival = productService.getProductById(arrival.getId());

        // then - -
        assertThat(testArrival.getName()).isEqualTo(arrival.getName());
    }

    @Test
    public void createProduct() {
        Product testClass = new Product();

        testClass.setName("mango");
        testClass.setId(5L);
        assertEquals("mango", testClass.getName());
        Assert.assertEquals("mango", testClass.getName());

        assertEquals(5, testClass.getId()); // 5 and 5L both work
    }

    @Test
    public void updateProduct() {
        var testProduct = new Product();
        testProduct.setName("apple");

//        var testResponse = productService.updateProduct(testProduct);
    }

    @Test
    public void deleteProduct() {
        final long result = new Calculator().add(2, 3);
        var result2 = calculator.add(4,2);

//        assertThat(result, is(5L));
        assertEquals(5, result);
        assertEquals(Long.valueOf(6), Long.valueOf(result2));

//        assertEquals(2, calculator.add(1,1));
    }

    @AfterClass
    public void tearDownClass() {
        // cleanup here like close URL connection , releasing resources etc
        product = null;
    }
}




/*
@Test(expected = IllegalArgumentException.class)
  public void testExceptionIsThrown() {
    tester.divide(1000, 0);
  }

  @Test
  public void testMultiply() {
    assertEquals("Result", 50, tester.multiply(10, 5));
  }
 */