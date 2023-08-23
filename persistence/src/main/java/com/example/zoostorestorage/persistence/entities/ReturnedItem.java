package com.example.zoostorestorage.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
    private BigDecimal price;
}
