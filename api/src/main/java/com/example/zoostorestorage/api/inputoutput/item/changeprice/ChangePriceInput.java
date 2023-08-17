package com.example.zoostorestorage.api.inputoutput.item.changeprice;

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
public class ChangePriceInput implements OperationInput {

    @NotBlank(message = "item id cannot be empty")
    private String itemId;
    @Positive
    private BigDecimal price;
}
