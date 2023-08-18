package com.example.zoostorestorage.core.processors.order;

import com.example.zoostorestorage.api.inputoutput.item.exportitem.ExportItemInput;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ItemExportOperation;
import com.example.zoostorestorage.api.inputoutput.order.*;
import com.example.zoostorestorage.persistence.entities.OrderItem;
import com.example.zoostorestorage.persistence.entities.OrderRecord;
import com.example.zoostorestorage.persistence.repositories.OrderItemRepository;
import com.example.zoostorestorage.persistence.repositories.OrderRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderRecordCreateOperationProcessor implements OrderRecordCreateOperation {

    private final OrderRecordRepository orderRecordRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemExportOperation itemExportOperation;

    @Override
    public CreateOrderRecordOutput process(CreateOrderRecordInput input) {

        OrderRecord orderRecord = OrderRecord.builder()
                .userId(input.getUserId())
                .items(new ArrayList<>())
                .coupon(input.getCoupon())
                .discount(input.getDiscount())
                .totalPrice(input.getTotalPrice())
                .build();
        orderRecordRepository.save(orderRecord);

        input.getItems().parallelStream()
                .map(o -> ExportItemInput.builder()
                        .itemId(o.getItemId())
                        .quantity(Integer.valueOf(o.getQuantity()))
                        .build())
                .forEach(itemExportOperation::process);

        List<OrderItem> orderItems = input.getItems().stream()
                .map(output -> OrderItem.builder()
                        .itemId(output.getItemId())
                        .quantity(output.getQuantity())
                        .price(output.getPrice())
                        .orderRecord(orderRecord)
                        .build())
                .peek(orderItemRepository::save)
                .collect(Collectors.toList());

        orderRecord.setItems(orderItems);
        orderRecordRepository.save(orderRecord);

        CreateOrderRecordOutput output = CreateOrderRecordOutput.builder()
                .id(orderRecord.getId().toString())
                .userId(orderRecord.getUserId())
                .items(orderRecord.getItems().stream()
                        .map(o -> OrderRecordItemOutput.builder()
                                .itemId(o.getItemId())
                                .quantity(o.getQuantity())
                                .price(o.getPrice())
                                .orderRecordId(orderRecord.getId().toString())
                                .build())
                        .collect(Collectors.toList()))
                .totalPrice(orderRecord.getTotalPrice())
                .date(orderRecord.getTimestamp().toString())
                .build();

        return output;
    }
}
