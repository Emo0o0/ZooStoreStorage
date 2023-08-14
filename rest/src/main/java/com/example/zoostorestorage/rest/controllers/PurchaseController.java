package com.example.zoostorestorage.rest.controllers;

import com.example.zoostorestorage.api.inputOutput.transaction.CreateOrderRecordInput;
import com.example.zoostorestorage.api.inputOutput.transaction.CreateOrderRecordOutput;
import com.example.zoostorestorage.api.inputOutput.transaction.OrderRecordCreateOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    private final OrderRecordCreateOperation orderRecordCreateOperation;

    @PostMapping
    public ResponseEntity<CreateOrderRecordOutput> createTransaction(@RequestBody CreateOrderRecordInput input){
        return ResponseEntity.status(201).body(orderRecordCreateOperation.process(input));
    }

}
