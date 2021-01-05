package org.atomiv.template.lite.web.restapi.dtos.product;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private Long id;

    private String name;
}
