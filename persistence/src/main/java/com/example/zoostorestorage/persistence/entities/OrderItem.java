package com.example.zoostorestorage.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String itemId;
    private String quantity;
    private String price;
    @ManyToOne
    private OrderRecord orderRecord;

}
