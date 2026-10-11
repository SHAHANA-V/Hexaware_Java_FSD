package com.springboot.FastX_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(length = 500)
    private String message;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
