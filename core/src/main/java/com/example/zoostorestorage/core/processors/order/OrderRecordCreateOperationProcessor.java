package com.example.zoostorestorage.core.processors.order;

import com.example.zoostorestorage.api.inputOutput.transaction.CreateOrderRecordInput;
import com.example.zoostorestorage.api.inputOutput.transaction.CreateOrderRecordOutput;
import com.example.zoostorestorage.api.inputOutput.transaction.OrderRecordCreateOperation;
import com.example.zoostorestorage.persistence.repositories.TransactionRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderRecordCreateOperationProcessor implements OrderRecordCreateOperation {

    private final TransactionRecordRepository transactionRecordRepository;
    @Override
    public CreateOrderRecordOutput process(CreateOrderRecordInput input) {

//        TransactionRecord transactionRecord=TransactionRecord.builder()
//                .userId(input.getUserId())
//                .itemId(input.getItemId())
//                .quantity(input.getQuantity())
//                .totalPrice(input.getTotalPrice())
//                .build();
//
//        transactionRecordRepository.save(transactionRecord);
//
//        CreateTransactionRecordOutput output=CreateTransactionRecordOutput.builder()
//                .id(transactionRecord.getId().toString())
//                .userId(transactionRecord.getUserId())
//                .itemId(transactionRecord.getItemId())
//                .quantity(transactionRecord.getQuantity())
//                .totalPrice(transactionRecord.getTotalPrice())
//                .date(transactionRecord.getTimestamp().toString())
//                .build();
//        return output;
        return null;
    }
}
