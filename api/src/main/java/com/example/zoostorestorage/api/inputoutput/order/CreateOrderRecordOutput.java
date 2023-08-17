package com.example.zoostorestorage.api.inputoutput.order;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRecordOutput implements OperationResult {

    private String id;
    private String userId;
    private List<OrderRecordItemOutput> items;
    private String totalPrice;
    private String date;

}
