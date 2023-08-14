package com.example.zoostorestorage.api.inputOutput.item.addItemToStorage;

import com.example.zoostorestorage.api.base.OperationResult;
import jakarta.validation.constraints.NotBlank;
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
