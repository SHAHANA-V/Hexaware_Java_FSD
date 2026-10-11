package com.FastX.model;

import com.FastX.enums.RouteStatus;
import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Enumerated(EnumType.STRING)
    private RouteStatus routeStatus;

    public Route() {

    }

    public Route(int id, String source, String destination, RouteStatus routeStatus) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.routeStatus = routeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public RouteStatus getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(RouteStatus routeStatus) {
        this.routeStatus = routeStatus;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", routeStatus=" + routeStatus +
                '}';
    }
}
