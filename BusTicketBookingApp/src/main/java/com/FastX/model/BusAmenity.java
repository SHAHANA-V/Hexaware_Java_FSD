package com.FastX.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bus_amenity")
public class BusAmenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Amenity amenity;

    public BusAmenity() {
    }

    public BusAmenity(int id, Bus bus, Amenity amenity) {
        this.id = id;
        this.bus = bus;
        this.amenity = amenity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Amenity getAmenity() {
        return amenity;
    }

    public void setAmenity(Amenity amenity) {
        this.amenity = amenity;
    }

    @Override
    public String toString() {
        return "BusAmenity{" +
                "id=" + id +
                ", bus=" + bus +
                ", amenity=" + amenity +
                '}';
    }
}
