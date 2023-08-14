package com.example.zoostorestorage.api.inputOutput.item.importItem;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemOutput implements OperationResult {
    private Integer quantity;
}
