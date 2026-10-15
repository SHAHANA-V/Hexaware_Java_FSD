package com.springboot.helpdesk.model;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer_plan")
public class CustomerPlan {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate activationDate;

    private LocalDate endDate;
    private String coupon;
    @Column(nullable = false)
    private double amountPaid;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "plan_id",nullable = false)
    private Plan plan;
}
