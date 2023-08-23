package com.example.zoostorestorage.api.inputoutput.orderreturnitems;

import com.example.zoostorestorage.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnItemInput implements OperationInput {

    @NotBlank
    private String itemId;
    @Positive
    private int quantity;

}
