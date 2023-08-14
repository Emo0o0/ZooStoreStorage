package com.example.zoostorestorage.core.processors.item;

import com.example.zoostorestorage.api.inputOutput.item.getItemFromStorage.GetItemFromStorageInput;
import com.example.zoostorestorage.api.inputOutput.item.getItemFromStorage.GetItemFromStorageOutput;
import com.example.zoostorestorage.api.inputOutput.item.getItemFromStorage.ItemGetFromStorageOperation;
import com.example.zoostorestorage.core.exceptions.ItemNotFoundException;
import com.example.zoostorestorage.persistence.entities.Storage;
import com.example.zoostorestorage.persistence.repositories.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemGetFromStorageOperationProcessor implements ItemGetFromStorageOperation {

    private final StorageRepository storageRepository;

    @Override
    public GetItemFromStorageOutput process(GetItemFromStorageInput input) {
        if (!storageRepository.existsByItemId(input.getItemId())) {
            throw new ItemNotFoundException("Item with such id does not exist");
        }
        Storage storage = storageRepository.findByItemId(input.getItemId());
        GetItemFromStorageOutput output = GetItemFromStorageOutput.builder()
                .id(storage.getId().toString())
                .itemId(storage.getItemId())
                .quantity(storage.getQuantity().toString())
                .price(storage.getPrice().toString())
                .build();
        return output;
    }
}
