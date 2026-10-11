package com.FastX.model;

import com.FastX.enums.ScheduleStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "journey_date",nullable = false)
    private Date journeyDate;

    @Column(name = "departure_time",nullable = false)
    private LocalTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @Column(nullable = false)
    private double fare;

    @Enumerated(EnumType.STRING)
    private ScheduleStatus scheduleStatus;

    @ManyToOne
    @JoinColumn(name = "bus_id",nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id",nullable = false)
    private Route route;

    public Schedule() {
    }

    public Schedule(int id, Date journeyDate, LocalTime departureTime, LocalTime arrivalTime, double fare, ScheduleStatus scheduleStatus, Bus bus, Route route) {
        this.id = id;
        this.journeyDate = journeyDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
        this.scheduleStatus = scheduleStatus;
        this.bus = bus;
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", journeyDate=" + journeyDate +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", fare=" + fare +
                ", scheduleStatus=" + scheduleStatus +
                ", bus=" + bus +
                ", route=" + route +
                '}';
    }
}
