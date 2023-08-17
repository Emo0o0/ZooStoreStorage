package com.example.zoostorestorage.core.processors.item;

import com.example.zoostorestorage.core.exceptions.ItemNotFoundException;
import com.example.zoostorestorage.core.exceptions.NegativeQuantityException;
import com.example.zoostorestorage.persistence.entities.Storage;
import com.example.zoostorestorage.persistence.repositories.StorageRepository;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ExportItemInput;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ExportItemOutput;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ItemExportOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemExportOperationProcessor implements ItemExportOperation {
    private final StorageRepository storageRepository;

    @Override
    public ExportItemOutput process(ExportItemInput input) {

        Boolean elementExists=storageRepository.existsByItemId(input.getItemId());
        if(!elementExists){
            throw new ItemNotFoundException("No element with the given id was found");
        }

        Storage storage = storageRepository.findByItemId(input.getItemId());

        if (storage.getQuantity() - input.getQuantity() < 0) {
            throw new NegativeQuantityException("Export amount is too much. Quantity cannot be " + (storage.getQuantity() - input.getQuantity()));
        }

        storage.setQuantity(storage.getQuantity() - input.getQuantity());
        storageRepository.save(storage);
        ExportItemOutput output = ExportItemOutput.builder()
                .quantity(storage.getQuantity())
                .build();
        return output;
    }
}
