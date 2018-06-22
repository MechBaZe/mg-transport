package ru.mg.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mg.microservices.entity.RoutePointGraph;

/**
 * JPA для работы с сущностью графа
 */
@Repository
public interface RoutePointGraphRepository extends CrudRepository<RoutePointGraph, Long> {
}
