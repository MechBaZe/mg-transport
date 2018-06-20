package ru.mg.microservices.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mg.microservices.entity.Route;
import ru.mg.microservices.routehelpers.RouteHelperController;
import ru.mg.microservices.routehelpers.RouteHeplerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class RoutesController {
    private Logger logger = Logger.getLogger(RoutesController.class.getName());
    private RoutesRepository routesRepository;

    public RoutesController(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    @GetMapping("/getRoutesList")
    public List<Route> getRoutesList() {
        return new ArrayList<>();
    }

    @GetMapping("/getRoute")
    public Route getRoute(Integer routeId) {
        return new Route();
    }

    @PostMapping("/addRoute")
    public Integer addRoute(List<Integer> routePointsList) {
        return 0;
    }
}
