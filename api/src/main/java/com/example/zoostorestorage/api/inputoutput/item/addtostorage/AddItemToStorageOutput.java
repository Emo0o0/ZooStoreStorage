package com.example.zoostorestorage.api.inputoutput.item.addtostorage;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToStorageOutput implements OperationResult {

    private String id;
    private String itemId;
    private Integer quantity;
    private BigDecimal price;
}
