package com.example.zoostorestorage.api.inputOutput.item.removeItemFromStorage;

import com.example.zoostorestorage.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemFromStorageInput implements OperationInput {

    @NotBlank(message = "item id cannot be empty")
    private String itemId;
}
