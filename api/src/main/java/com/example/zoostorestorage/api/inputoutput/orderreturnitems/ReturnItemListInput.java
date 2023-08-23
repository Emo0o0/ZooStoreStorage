package com.example.zoostorestorage.api.inputoutput.orderreturnitems;

import com.example.zoostorestorage.api.base.OperationInput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnItemListInput implements OperationInput {

    private String userId;
    private String orderRecordId;
    private List<ReturnItemInput> itemsForReturn;

}
