package ru.mg.microservices.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROUTE_POINT")
public class RoutePoint {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long Id;
    @Column(name = "id_route")
    private long routeId;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }
}
