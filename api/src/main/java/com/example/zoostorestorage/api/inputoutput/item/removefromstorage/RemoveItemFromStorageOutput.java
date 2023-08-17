package com.example.zoostorestorage.api.inputoutput.item.removefromstorage;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemFromStorageOutput implements OperationResult {
    private String itemId;
}
