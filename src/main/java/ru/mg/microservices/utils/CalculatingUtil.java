package ru.mg.microservices.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mg.microservices.entity.RoutePoint;
import ru.mg.microservices.entity.RoutePointGraph;
import ru.mg.microservices.repository.RoutePointGraphRepository;

import java.util.List;

@Component
public class CalculatingUtil {

    private final RoutePointGraphRepository routePointGraphRepository;

    @Autowired
    public CalculatingUtil(RoutePointGraphRepository routePointGraphRepository) {
        this.routePointGraphRepository = routePointGraphRepository;
    }

    public Integer calculateRouteTime(List<RoutePoint> pointGraph) {
       return 0;
    }
}
