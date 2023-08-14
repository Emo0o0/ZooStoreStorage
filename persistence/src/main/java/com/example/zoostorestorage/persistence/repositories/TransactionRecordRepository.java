package com.example.zoostorestorage.persistence.repositories;

import com.example.zoostorestorage.persistence.entities.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRecordRepository extends JpaRepository<OrderRecord, UUID> {
}
