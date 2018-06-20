package ru.mg.microservices.routehelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mg.microservices.entity.RoutePoint;
import ru.mg.microservices.repository.RoutePointGraphRepository;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class RouteHelperController {
    private Logger logger = Logger.getLogger(RouteHelperController.class.getName());
    private RoutePointGraphRepository routePointGraphRepository;

    @Autowired
    public RouteHelperController(RoutePointGraphRepository routePointGraphRepository) {
        this.routePointGraphRepository = routePointGraphRepository;
    }

    @GetMapping("/getTimeForRoute")
    public Integer getTimeForRoute(List<RoutePoint> pointsList) {

        return -1;
    }
}
