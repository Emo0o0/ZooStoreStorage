package com.example.zoostorestorage.restexport;

import com.example.zoostorestorage.api.inputoutput.item.getfromstorage.GetItemFromStorageOutput;
import com.example.zoostorestorage.api.inputoutput.order.CreateOrderRecordInput;
import com.example.zoostorestorage.api.inputoutput.order.CreateOrderRecordOutput;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemListInput;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface ZooStorageRestClient {

    @RequestLine("GET /item/{id}")
    GetItemFromStorageOutput getItemFromStorage(@Param("id") String id);

    @RequestLine("POST /purchase")
    CreateOrderRecordOutput createOrderRecord(CreateOrderRecordInput input);

    @RequestLine("POST /purchase/return")
    ReturnItemOutput returnItems(ReturnItemListInput input);
}