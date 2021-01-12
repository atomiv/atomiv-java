package org.atomiv.template.lite.web.restapi.dtos.order;

import lombok.Data;

import java.util.List;

@Data
public class GetAllOrdersResponse {

    public List<GetAllOrdersRecordResponse> records;
}
