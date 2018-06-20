package ru.mg.microservices.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mg.microservices.entity.Route;

import ru.mg.microservices.entity.RoutePoint;
import ru.mg.microservices.repository.RoutePointGraphRepository;
import ru.mg.microservices.repository.RoutePointsRepository;
import ru.mg.microservices.repository.RoutesRepository;
import ru.mg.microservices.utils.CalculatingUtil;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class RoutesController {
    private Logger logger = Logger.getLogger(RoutesController.class.getName());
    private RoutesRepository routesRepository;
    private RoutePointsRepository routePointsRepository;
    private CalculatingUtil calculatingUtil;

    @Autowired
    public RoutesController(RoutesRepository routesRepository, RoutePointsRepository routePointsRepository, CalculatingUtil calculatingUtil) {
        this.routesRepository = routesRepository;
        this.routePointsRepository = routePointsRepository;
        this.calculatingUtil = calculatingUtil;
    }

    @GetMapping("/getRoutesList")
    public List<Route> getRoutesList() {
        return (List<Route>) routesRepository.findAll();
    }

    @GetMapping("/getRoute")
    public Route getRoute(Long routeId) {
        return routesRepository.findOne(routeId);
    }

    @PostMapping("/addRoute")
    public Integer addRoute(List<Long> routePointsList) {
        Route route = new Route();
        List<RoutePoint> routePoints = (List<RoutePoint>) routePointsRepository.findAll(routePointsList);
        route.setPoints(routePoints);
        route.setTime(calculatingUtil.calculateRouteTime(routePoints));
        routesRepository.save(route);
        return 0;
    }
}
