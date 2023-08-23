package com.example.zoostorestorage.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "returned_items")
public class ReturnedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String orderRecordId;
    private String itemId;
    private int quantity;
    private BigDecimal pricePer;
    @CreationTimestamp
    private Timestamp timestamp;
}
