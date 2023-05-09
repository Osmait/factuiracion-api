package com.example.facturationproject.domain.transaction;


import com.example.facturationproject.domain.Sale.Sale;
import com.example.facturationproject.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private String description;

    @Column(name = "deleted",columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(nullable = false,name = "create_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sale_id")
    private Sale sale;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;


}
