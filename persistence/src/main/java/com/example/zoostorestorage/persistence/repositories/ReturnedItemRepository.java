package com.example.zoostorestorage.persistence.repositories;

import com.example.zoostorestorage.persistence.entities.ReturnedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReturnedItemRepository extends JpaRepository<ReturnedItem, UUID> {
}
