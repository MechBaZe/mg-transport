package ru.mg.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mg.microservices.entity.RoutePoint;

/**
 * JPA для работы с сущностью точек
 */
@Repository
public interface RoutePointsRepository extends CrudRepository<RoutePoint, Long> {
}
