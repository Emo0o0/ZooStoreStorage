package com.example.zoostorestorage.core.processors.item;

import com.example.zoostore.restexport.ZooStoreRestClient;
import com.example.zoostorestorage.core.exceptions.ItemAlreadyExistsException;
import com.example.zoostorestorage.core.exceptions.ItemNotFoundException;
import com.example.zoostorestorage.persistence.entities.Storage;
import com.example.zoostorestorage.persistence.repositories.StorageRepository;
import com.example.zoostorestorage.api.inputOutput.item.addItemToStorage.AddItemToStorageInput;
import com.example.zoostorestorage.api.inputOutput.item.addItemToStorage.AddItemToStorageOutput;
import com.example.zoostorestorage.api.inputOutput.item.addItemToStorage.ItemAddToStorageOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemAddToStorageOperationProcessor implements ItemAddToStorageOperation {

    private final StorageRepository storageRepository;
    private final ZooStoreRestClient zooStoreRestClient;

    @Override
    public AddItemToStorageOutput process(AddItemToStorageInput input) {

        try{
            zooStoreRestClient.getItemById(input.getItemId());
        }catch(Exception e){
            throw new ItemNotFoundException("GRYM");
        }

        Storage storage = Storage.builder()
                .itemId(input.getItemId())
                .quantity(input.getQuantity())
                .price(input.getPrice())
                .build();

        if(storageRepository.existsByItemId(storage.getItemId())){
           throw new ItemAlreadyExistsException("This item was already added to storage");
        }

        storageRepository.save(storage);

        AddItemToStorageOutput output = AddItemToStorageOutput.builder()
                .id(storage.getId().toString())
                .itemId(storage.getItemId())
                .quantity(storage.getQuantity())
                .price(storage.getPrice())
                .build();

        return output;
    }
}
