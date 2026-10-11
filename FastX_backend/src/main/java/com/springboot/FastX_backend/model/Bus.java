package com.springboot.FastX_backend.model;

import com.springboot.FastX_backend.enums.AcType;
import com.springboot.FastX_backend.enums.BusType;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "bus_number",nullable = false)
    private String busNumber;

    @Column(name = "bus_name",nullable = false)
    private String busName;

    @Enumerated(EnumType.STRING)
    private BusType busType;

    @Column(name = "total_seats")
    private int totalSeats;

    @Enumerated(EnumType.STRING)
    private AcType acType;

    @ManyToOne
    @JoinColumn(name = "bus_operator_id",nullable = false)
    private BusOperator busOperator;
}
