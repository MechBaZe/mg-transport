package ru.mg.microservices.entity;


import javax.persistence.*;

@Entity
@Table(name = "ROUTE")
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long Id;
    @Column(name = "is_ready")
    private boolean ready;
    @Column(name = "time")
    private int time;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
