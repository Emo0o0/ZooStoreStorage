package com.example.zoostorestorage.core.processors.item;

import com.example.zoostorestorage.core.exceptions.ItemNotFoundException;
import com.example.zoostorestorage.persistence.entities.Storage;
import com.example.zoostorestorage.persistence.repositories.StorageRepository;
import com.example.zoostorestorage.api.inputOutput.item.removeItemFromStorage.ItemRemoveOperation;
import com.example.zoostorestorage.api.inputOutput.item.removeItemFromStorage.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.inputOutput.item.removeItemFromStorage.RemoveItemFromStorageOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemRemoveFromStorageOperationProcessor implements ItemRemoveOperation {

    private final StorageRepository storageRepository;

    @Override
    public RemoveItemFromStorageOutput process(RemoveItemFromStorageInput input) {

        Boolean elementExists=storageRepository.existsByItemId(input.getItemId());
        if(!elementExists){
            throw new ItemNotFoundException("No element with the given id was found");
        }

        Storage storage = storageRepository.findByItemId(input.getItemId());
        storageRepository.delete(storage);
        return RemoveItemFromStorageOutput.builder().itemId(input.getItemId()).build();
    }
}
