package ru.mg.microservices.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROUTE_POINT_GRAPH")
public class RoutePointGraph {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long Id;

    @Column(name = "id_point_first")
    private long firstPointId;
    @Column(name = "id_point_second")
    private long secondPointId;
    @Column(name = "time")
    private int time;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getFirstPointId() {
        return firstPointId;
    }

    public void setFirstPointId(long firstPointId) {
        this.firstPointId = firstPointId;
    }

    public long getSecondPointId() {
        return secondPointId;
    }

    public void setSecondPointId(long secondPointId) {
        this.secondPointId = secondPointId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
