package com.example.zoostorestorage.api.inputOutput.item.exportItem;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemOutput implements OperationResult {
    private Integer quantity;
}
