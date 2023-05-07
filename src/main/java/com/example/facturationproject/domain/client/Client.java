package com.example.facturationproject.domain.client;

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

    @Column(name = "deleted",columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;


}
