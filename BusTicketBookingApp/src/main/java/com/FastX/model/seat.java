package com.FastX.model;

import com.FastX.enums.SeatType;
import jakarta.persistence.*;

@Entity
public class seat {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number",nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Bus bus;

    public seat() {
    }

    public seat(int id, String seatNumber, SeatType seatType, Bus bus) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "seat{" +
                "id=" + id +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType=" + seatType +
                ", bus=" + bus +
                '}';
    }
}
