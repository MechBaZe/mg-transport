package ru.mg.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mg.microservices.entity.Route;

@Repository
public interface RoutesRepository extends CrudRepository<Route, Long> {
}
