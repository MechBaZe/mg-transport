package ru.mg.microservices.entity;

import javax.persistence.*;

/**
 * Сущность графа точек маршрута
 */
@Entity
@Table(name = "ROUTE_POINT_GRAPH")
public class RoutePointGraph {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long Id;

    /**
     * ид первой точки маршрута
     */
    @OneToOne
    @JoinColumn(name = "id_point_first")
    private RoutePoint firstPoint;

    /**
     * ид второй точки маршрута
     */
    @OneToOne
    @JoinColumn(name = "id_point_second")
    private RoutePoint secondPoint;

    /**
     * время затраченое на путь между точками
     */
    @Column(name = "time")
    private int time;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public RoutePoint getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(RoutePoint firstPoint) {
        this.firstPoint = firstPoint;
    }

    public RoutePoint getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(RoutePoint secondPoint) {
        this.secondPoint = secondPoint;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
