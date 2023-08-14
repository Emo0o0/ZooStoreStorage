package com.example.zoostorestorage.api.inputOutput.item.getItemFromStorage;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemFromStorageOutput implements OperationResult {

    private String id;
    private String itemId;
    private String quantity;
    private String price;

}
