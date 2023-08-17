package com.example.zoostorestorage.api.inputoutput.item.importitem;

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
