package com.example.zoostorestorage.persistence.repositories;

import com.example.zoostorestorage.persistence.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StorageRepository extends JpaRepository<Storage, Long> {

    Storage findByItemId(String itemId);

    List<Storage> findAllByItemIdIn(List<UUID> uuids);
    Boolean existsByItemId(String itemId);


}
