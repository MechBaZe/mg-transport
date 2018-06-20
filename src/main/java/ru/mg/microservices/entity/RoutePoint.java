package ru.mg.microservices.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROUTE_POINT")
public class RoutePoint {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long Id;
    @ManyToOne
    @JoinColumn(name = "id_route")
    private Route route;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
