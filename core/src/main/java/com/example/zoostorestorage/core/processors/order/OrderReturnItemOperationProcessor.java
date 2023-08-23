package com.example.zoostorestorage.core.processors.order;

import com.example.zoostorestorage.api.inputoutput.item.importitem.ImportItemInput;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ItemImportOperation;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.OrderReturnItemOperation;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemInput;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemListInput;
import com.example.zoostorestorage.api.inputoutput.orderreturnitems.ReturnItemOutput;
import com.example.zoostorestorage.core.exceptions.*;
import com.example.zoostorestorage.persistence.entities.OrderItem;
import com.example.zoostorestorage.persistence.entities.OrderRecord;
import com.example.zoostorestorage.persistence.entities.ReturnedItem;
import com.example.zoostorestorage.persistence.repositories.OrderItemRepository;
import com.example.zoostorestorage.persistence.repositories.OrderRecordRepository;
import com.example.zoostorestorage.persistence.repositories.ReturnedItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.cms.TimeStampAndCRL;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderReturnItemOperationProcessor implements OrderReturnItemOperation {

    private final OrderRecordRepository orderRecordRepository;
    private final OrderItemRepository orderItemRepository;
    private final ReturnedItemRepository returnedItemRepository;
    private final ItemImportOperation itemImportOperation;

    @Override
    public ReturnItemOutput process(ReturnItemListInput input) {

        Integer daysUntilNoReturn = 14;

        OrderRecord orderRecord = orderRecordRepository.findById(UUID.fromString(input.getOrderRecordId()))
                .orElseThrow(() -> new OrderRecordNotFoundException("Order record not found"));

        LocalDateTime datePurchased = orderRecord.getTimestamp().toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
        LocalDateTime currentDate = Instant.now().atZone(ZoneId.of("UTC")).toLocalDateTime();

        if (datePurchased.plusDays(daysUntilNoReturn).isBefore(currentDate)) {
            throw new PastReturnDateException(daysUntilNoReturn + " days have passed. Items cannot be returned");
        }

        log.info("User ID from order record : {}", orderRecord.getUserId());
        log.info("User ID from input : {}", input.getUserId());

        if (!orderRecord.getUserId().equals(input.getUserId())) {

            throw new WrongRecordException("An order with this id was not found");
        }

        Set<String> orderRecordItemsIds = orderRecord.getItems().stream()
                .map(OrderItem::getItemId)
                .collect(Collectors.toSet());

        Set<String> inputItemsIds = input.getItemsForReturn().stream()
                .map(ReturnItemInput::getItemId)
                .collect(Collectors.toSet());

        if (!orderRecordItemsIds.containsAll(inputItemsIds)) {
            throw new ItemNotFoundException("An item was not found in your cart from order " + orderRecord.getId().toString());
        }


        input.getItemsForReturn().forEach(item -> orderRecord.getItems().stream()
                .filter(orderItem -> item.getItemId().equals(orderItem.getItemId()))
                .findFirst()
                .ifPresent(orderItem -> {
                    int quantity = Integer.parseInt(orderItem.getQuantity()) - item.getQuantity();
                    if (quantity < 0) {
                        throw new InsufficientQuantityException("Can't return more than you purchased");
                    }

                    int itemIndex = orderRecord.getItems().indexOf(orderItem);
                    OrderItem orderItem1 = orderRecord.getItems().get(itemIndex);
                    orderItem1.setQuantity(String.valueOf(quantity));
                    //orderItem.setQuantity(String.valueOf(quantity));
                    orderItemRepository.save(orderItem1);
                    OrderRecord save = orderRecordRepository.save(orderRecord);

                    ReturnedItem returnedItem = ReturnedItem.builder()
                            .orderRecordId(save.getId().toString())
                            .itemId(orderItem.getItemId())
                            .quantity(Integer.parseInt(orderItem.getQuantity()))
                            .price(BigDecimal.valueOf(Double.valueOf(orderItem.getPrice())))
                            .build();
                    returnedItemRepository.save(returnedItem);

                    if (quantity == 0) {
                        orderRecord.getItems().remove(orderItem);
                        orderItemRepository.delete(orderItem);
                        orderRecordRepository.save(orderRecord);
                    }

                    ImportItemInput importInput = ImportItemInput.builder()
                            .itemId(item.getItemId())
                            .quantity(item.getQuantity())
                            .build();
                    itemImportOperation.process(importInput);
                })
        );


        ReturnItemOutput output = ReturnItemOutput.builder()
                .success(true)
                .build();
        return output;

    }
}