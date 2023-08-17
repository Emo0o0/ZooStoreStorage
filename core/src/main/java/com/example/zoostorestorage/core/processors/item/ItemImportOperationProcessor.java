package com.example.zoostorestorage.core.processors.item;

import com.example.zoostorestorage.core.exceptions.ItemNotFoundException;
import com.example.zoostorestorage.persistence.entities.Storage;
import com.example.zoostorestorage.persistence.repositories.StorageRepository;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ImportItemInput;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ImportItemOutput;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ItemImportOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemImportOperationProcessor implements ItemImportOperation {

    private final StorageRepository storageRepository;

    @Override
    public ImportItemOutput process(ImportItemInput input) {

        Boolean elementExists = storageRepository.existsByItemId(input.getItemId());
        if (!elementExists) {
            throw new ItemNotFoundException("No element with the given id was found");
        }

        Storage storage = storageRepository.findByItemId(input.getItemId());
        storage.setQuantity(storage.getQuantity() + input.getQuantity());
        storageRepository.save(storage);
        ImportItemOutput output = ImportItemOutput.builder()
                .quantity(storage.getQuantity())
                .build();
        return output;
    }
}
