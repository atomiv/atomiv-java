package org.atomiv.template.lite.web.restapi.repositories;

import org.atomiv.template.lite.web.restapi.models.OrderItem;
import org.atomiv.template.lite.web.restapi.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

//    // TO DO pass in product id
//    // findByOrderItem
//    @Query("select p from Product p where ?1 MEMBER OF p.orderItems")
//    public Product findByOrderItemProductId(Long id);

    //How do you create/get the Author you are passing as parameter?
    //No, retrieve an Author from the database as clearly stated in the answer. So create an Author Repository definition just like the above but for Authors and use the inherited findOne(..) method to get the existing persistent instance.
}




//public interface BookRepository extends JpaRepository<Book, Integer> {
//
//    @Query("select b from Book b where ?1 MEMBER OF b.authors")
//    List<Book> findByAuthor(Author author);
//}