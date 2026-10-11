package com.FastX.model;

import com.FastX.enums.AcType;
import com.FastX.enums.BusType;
import jakarta.persistence.*;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

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

    public Bus() {
    }

    public Bus(int id, String busNumber, String busName, BusType busType, int totalSeats, AcType acType, BusOperator busOperator) {
        this.id = id;
        this.busNumber = busNumber;
        this.busName = busName;
        this.busType = busType;
        this.totalSeats = totalSeats;
        this.acType = acType;
        this.busOperator = busOperator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public AcType getAcType() {
        return acType;
    }

    public void setAcType(AcType acType) {
        this.acType = acType;
    }

    public BusOperator getBusOperator() {
        return busOperator;
    }

    public void setBusOperator(BusOperator busOperator) {
        this.busOperator = busOperator;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busNumber='" + busNumber + '\'' +
                ", busName='" + busName + '\'' +
                ", busType=" + busType +
                ", totalSeats=" + totalSeats +
                ", acType=" + acType +
                ", busOperator=" + busOperator +
                '}';
    }
}
