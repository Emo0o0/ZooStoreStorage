package com.example.zoostorestorage.api.inputoutput.item.addtostorage;

import com.example.zoostorestorage.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToStorageInput implements OperationInput {

    @NotBlank(message = "item id cannot be empty")
    private String itemId;
    @Positive(message = "asd")
    private Integer quantity;
    @Positive(message = "das")
    private BigDecimal price;
}
