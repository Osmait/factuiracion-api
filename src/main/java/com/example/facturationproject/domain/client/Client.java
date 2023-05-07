package com.example.facturationproject.domain.client;

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
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false ,name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String phone;

    @Column
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(name = "deleted")
    private Boolean deleted ;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

}
