package org.atomiv.template.lite.web.restapi.dtos.product;

import lombok.Data;

import java.util.List;

@Data
public class GetAllProductsResponse {
     public List<GetAllProductsRecordResponse> records;
}
