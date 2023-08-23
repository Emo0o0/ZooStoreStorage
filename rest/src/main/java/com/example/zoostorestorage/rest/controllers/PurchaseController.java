package com.example.zoostorestorage.rest.controllers;

import com.example.zoostorestorage.api.inputoutput.order.CreateOrderRecordInput;
import com.example.zoostorestorage.api.inputoutput.order.CreateOrderRecordOutput;
import com.example.zoostorestorage.api.inputoutput.order.OrderRecordCreateOperation;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.OrderReturnItemOperation;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemInput;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemListInput;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final OrderRecordCreateOperation orderRecordCreateOperation;
    private final OrderReturnItemOperation orderReturnItemOperation;

    @PostMapping
    public ResponseEntity<CreateOrderRecordOutput> createOrderRecord(@RequestBody CreateOrderRecordInput input) {
        return ResponseEntity.status(201).body(orderRecordCreateOperation.process(input));
    }

    @PostMapping(path = "/return")
    public ResponseEntity<ReturnItemOutput> returnItems(@RequestBody ReturnItemListInput input) {
        return ResponseEntity.status(200).body(orderReturnItemOperation.process(input));
    }

}
