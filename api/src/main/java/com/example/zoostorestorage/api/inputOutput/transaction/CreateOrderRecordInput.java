package com.example.zoostorestorage.api.inputOutput.transaction;

import com.example.zoostorestorage.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRecordInput implements OperationInput {

    private String userId;
    private String itemId;
    private String quantity;
    private String totalPrice;
}
