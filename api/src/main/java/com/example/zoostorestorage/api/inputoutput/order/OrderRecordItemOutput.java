package com.example.zoostorestorage.api.inputoutput.order;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRecordItemOutput implements OperationResult {

    private String itemId;
    private String quantity;
    private String price;
    private String orderRecordId;
}
