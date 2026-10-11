package com.springboot.FastX_backend.model;

import com.springboot.FastX_backend.enums.BookingStatus;
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
public class Booking {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "total_amount",nullable = false)
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @CreationTimestamp
    private Instant bookedAt;
    @ManyToOne
    @JoinColumn(name = "passenger_id",nullable = false)
    private Passenger passenger;
    @ManyToOne
    @JoinColumn(name = "schedule_id",nullable = false)
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "route_stop_id",nullable = false)
    private RouteStop routeStop;
}
