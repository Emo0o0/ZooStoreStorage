package com.example.zoostorestorage.api.inputoutput.orderreturnitems;

import com.example.zoostorestorage.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnItemOutput implements OperationResult {

    private Boolean success;
}
