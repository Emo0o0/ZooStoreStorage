package com.example.zoostorestorage.api.inputoutput.item.getfromstorage;

import com.example.zoostorestorage.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemFromStorageInput implements OperationInput {

    @NotBlank(message = "Item id cannot be blank")
    private String itemId;
}
