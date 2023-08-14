package com.example.zoostorestorage.core.processors.item;

import com.example.zoostorestorage.core.exceptions.ItemNotFoundException;
import com.example.zoostorestorage.core.exceptions.PriceIsNotPositiveException;
import com.example.zoostorestorage.persistence.entities.Storage;
import com.example.zoostorestorage.persistence.repositories.StorageRepository;
import com.example.zoostorestorage.api.inputOutput.item.changeItemPrice.ChangePriceInput;
import com.example.zoostorestorage.api.inputOutput.item.changeItemPrice.ChangePriceOutput;
import com.example.zoostorestorage.api.inputOutput.item.changeItemPrice.ItemChangePriceOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemChangePriceOperationProcessor implements ItemChangePriceOperation {

    private final StorageRepository storageRepository;

    @Override
    public ChangePriceOutput process(ChangePriceInput input) {

        Boolean elementExists=storageRepository.existsByItemId(input.getItemId());
        if(!elementExists){
            throw new ItemNotFoundException("No element with the given id was found");
        }

        if(input.getPrice().doubleValue()<=0){
            throw new PriceIsNotPositiveException("The price should be a positive number");
        }

        Storage storage=storageRepository.findByItemId(input.getItemId());

        storage.setPrice(input.getPrice());
        storageRepository.save(storage);

        ChangePriceOutput output = ChangePriceOutput.builder()
                .price(storage.getPrice())
                .build();
        return output;
    }
}
