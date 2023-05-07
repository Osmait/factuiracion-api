package com.example.facturationproject.domain.Sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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

    @Column(name = "deleted")
    private Boolean deleted;


    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;





}
