package com.example.zoostorestorage.api.inputoutput.item.changeprice;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePriceOutput implements OperationResult {
    private BigDecimal price;
}
