package com.example.facturationproject.domain.Sale;

import com.example.facturationproject.domain.client.Client;
import com.example.facturationproject.domain.transaction.Transaction;
import com.example.facturationproject.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @Column(nullable = false)
    private String price;

    @Column(name = "deleted",columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "sale" )
    @JsonManagedReference
    private List<Transaction> transactions;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;






}
