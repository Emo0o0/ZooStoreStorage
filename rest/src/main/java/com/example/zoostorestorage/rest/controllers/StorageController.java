package com.example.zoostorestorage.rest.controllers;

import com.example.zoostorestorage.api.inputoutput.item.addtostorage.AddItemToStorageInput;
import com.example.zoostorestorage.api.inputoutput.item.addtostorage.AddItemToStorageOutput;
import com.example.zoostorestorage.api.inputoutput.item.addtostorage.ItemAddToStorageOperation;
import com.example.zoostorestorage.api.inputoutput.item.changeprice.ChangePriceInput;
import com.example.zoostorestorage.api.inputoutput.item.changeprice.ChangePriceOutput;
import com.example.zoostorestorage.api.inputoutput.item.changeprice.ItemChangePriceOperation;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ExportItemInput;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ExportItemOutput;
import com.example.zoostorestorage.api.inputoutput.item.exportitem.ItemExportOperation;
import com.example.zoostorestorage.api.inputoutput.item.getfromstorage.GetItemFromStorageInput;
import com.example.zoostorestorage.api.inputoutput.item.getfromstorage.GetItemFromStorageOutput;
import com.example.zoostorestorage.api.inputoutput.item.getfromstorage.ItemGetFromStorageOperation;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ImportItemInput;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ImportItemOutput;
import com.example.zoostorestorage.api.inputoutput.item.importitem.ItemImportOperation;
import com.example.zoostorestorage.api.inputoutput.item.removefromstorage.ItemRemoveOperation;
import com.example.zoostorestorage.api.inputoutput.item.removefromstorage.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.inputoutput.item.removefromstorage.RemoveItemFromStorageOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StorageController {

    private final ItemAddToStorageOperation itemAddToStorageOperation;
    private final ItemImportOperation itemImportOperation;
    private final ItemExportOperation itemExportOperation;
    private final ItemChangePriceOperation itemChangePriceOperation;
    private final ItemRemoveOperation itemRemoveOperation;
    private final ItemGetFromStorageOperation itemGetFromStorageOperation;

    @PostMapping(path = "item/add")
    public ResponseEntity<AddItemToStorageOutput> addItemToStorage(@Valid @RequestBody AddItemToStorageInput input) {
        return ResponseEntity.status(200).body(itemAddToStorageOperation.process(input));
    }

    @PatchMapping(path = "item/import")
    public ResponseEntity<ImportItemOutput> importItem(@Valid @RequestBody ImportItemInput input) {
        return ResponseEntity.status(200).body(itemImportOperation.process(input));
    }

    @PatchMapping(path = "item/export")
    public ResponseEntity<ExportItemOutput> exportItem(@Valid @RequestBody ExportItemInput input) {
        return ResponseEntity.status(200).body(itemExportOperation.process(input));
    }

    @PatchMapping(path = "item/changePrice")
    public ResponseEntity<ChangePriceOutput> changePrice(@Valid @RequestBody ChangePriceInput input) {
        return ResponseEntity.status(200).body(itemChangePriceOperation.process(input));
    }

    @DeleteMapping(path = "item/delete")
    public ResponseEntity<RemoveItemFromStorageOutput> removeItemFromStorage(@Valid @RequestBody RemoveItemFromStorageInput input) {
        return ResponseEntity.status(200).body(itemRemoveOperation.process(input));
    }

    @GetMapping(path = "item/{id}")
    public ResponseEntity<GetItemFromStorageOutput> getItemFromStorage(@Valid @PathVariable String id) {
        GetItemFromStorageInput input = GetItemFromStorageInput.builder()
                .itemId(id)
                .build();
        return ResponseEntity.status(200).body(itemGetFromStorageOperation.process(input));
    }
}
