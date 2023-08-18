package com.example.zoostorestorage.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_records")
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String userId;
    @OneToMany(mappedBy = "orderRecord")
    private List<OrderItem> items;
    private String totalPrice;
    private String coupon;
    private String discount;
    @CreationTimestamp
    private Timestamp timestamp;

}
