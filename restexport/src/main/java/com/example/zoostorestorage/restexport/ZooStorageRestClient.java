package com.example.zoostorestorage.restexport;

import com.example.zoostorestorage.api.inputOutput.item.getItemFromStorage.GetItemFromStorageOutput;
import com.example.zoostorestorage.api.inputOutput.order.CreateOrderRecordInput;
import com.example.zoostorestorage.api.inputOutput.order.CreateOrderRecordOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface ZooStorageRestClient {

    @RequestLine("GET /item/{id}")
    GetItemFromStorageOutput getItemFromStorage(@Param("id") String id);

    @RequestLine("POST /purchase")
    CreateOrderRecordOutput createOrderRecord(CreateOrderRecordInput input);
}