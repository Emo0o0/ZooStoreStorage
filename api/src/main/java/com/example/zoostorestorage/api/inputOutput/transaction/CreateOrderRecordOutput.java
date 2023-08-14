package com.example.zoostorestorage.api.inputOutput.transaction;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRecordOutput implements OperationResult {

    private String id;
    private String userId;
    private String itemId;
    private String quantity;
    private String totalPrice;
    private String date;

}
