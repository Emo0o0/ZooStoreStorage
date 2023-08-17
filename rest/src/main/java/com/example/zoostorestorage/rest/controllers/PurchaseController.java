package com.example.zoostorestorage.rest.controllers;

import com.example.zoostorestorage.api.inputoutput.order.CreateOrderRecordInput;
import com.example.zoostorestorage.api.inputoutput.order.CreateOrderRecordOutput;
import com.example.zoostorestorage.api.inputoutput.order.OrderRecordCreateOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final OrderRecordCreateOperation orderRecordCreateOperation;

    @PostMapping
    public ResponseEntity<CreateOrderRecordOutput>  createOrderRecord(@RequestBody CreateOrderRecordInput input){
        return ResponseEntity.status(201).body(orderRecordCreateOperation.process(input));
    }

}
