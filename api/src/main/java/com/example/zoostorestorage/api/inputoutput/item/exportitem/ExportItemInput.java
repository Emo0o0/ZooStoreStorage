package com.example.zoostorestorage.api.inputoutput.item.exportitem;

import com.example.zoostorestorage.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemInput implements OperationInput {

    @NotBlank(message = "item id cannot be empty")
    private String itemId;
    @Positive
    private Integer quantity;
}
