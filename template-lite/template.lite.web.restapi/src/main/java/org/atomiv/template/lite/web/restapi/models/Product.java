package org.atomiv.template.lite.web.restapi.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    LocalDateTime lastModified;// = LocalDateTime.now();
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    //System.out.println(dtf.format(now));

//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//    Date date = new Date();
//    System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

    public Product() {
    }
}
