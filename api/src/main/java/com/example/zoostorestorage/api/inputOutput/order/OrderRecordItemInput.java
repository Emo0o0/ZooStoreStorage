package com.example.zoostorestorage.api.inputOutput.order;

import com.example.zoostorestorage.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRecordItemInput implements OperationInput {

    private String itemId;
    private String quantity;
    private String price;
    //private String orderRecordId;
}
