package com.springboot.helpdesk.model;

import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.Status;
import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String subject;
    @Column(length = 1000)
    private String issue;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "executive_id")
    private Executive executive;

}
