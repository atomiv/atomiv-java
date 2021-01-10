package org.atomiv.template.lite.web.restapi.dtos.order_item;

import lombok.Data;

import java.util.List;

@Data
public class GetAllOrderItemsResponse {

    public List<GetAllOrderItemsRecordResponse> records;
}
