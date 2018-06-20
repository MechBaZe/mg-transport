package ru.mg.microservices.routehelpers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mg.microservices.entity.RoutePoint;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class RouteHelperController {
    private Logger logger = Logger.getLogger(RouteHelperController.class.getName());
    private RouteHeplerRepository routeHeplerRepository;

    public RouteHelperController(RouteHeplerRepository routeHeplerRepository) {
        this.routeHeplerRepository = routeHeplerRepository;
    }

    @GetMapping("/getTimeForRoute")
    public Integer getTimeForRoute(List<RoutePoint> pointsList) {
        return -1;
    }
}
