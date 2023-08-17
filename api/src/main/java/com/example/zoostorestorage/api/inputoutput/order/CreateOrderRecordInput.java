package com.example.zoostorestorage.api.inputoutput.order;

import com.example.zoostorestorage.api.base.OperationInput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRecordInput implements OperationInput {

    private String userId;
    private List<OrderRecordItemOutput> items;
    private String totalPrice;
}
