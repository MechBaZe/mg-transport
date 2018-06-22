package ru.mg.microservices.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.mg.microservices.entity.Route;

import ru.mg.microservices.entity.RoutePoint;
import ru.mg.microservices.repository.RoutePointsRepository;
import ru.mg.microservices.repository.RoutesRepository;
import ru.mg.microservices.utils.CalculatingUtil;

import java.util.List;
import java.util.logging.Logger;

/**
 * Контроллер для сервиса-маршрутов
 * CrossOrigin для кроссдоменных запросов
 */
@CrossOrigin
@RestController
public class RoutesController {
    /**
     * урл хелпер-сервиса
     */
    private static final String ROUTE_HELPERS_SERVICE_URL = "routeheplers-server";
    private Logger logger = Logger.getLogger(RoutesController.class.getName());
    private RoutesRepository routesRepository;
    private RoutePointsRepository routePointsRepository;
    private CalculatingUtil calculatingUtil;

    /**
     * бин для обращения к сервисам
     */
    @Autowired
    RestTemplate restTemplate;

    /**
     * Конструктор с DI
     * @param routesRepository
     * @param routePointsRepository
     * @param calculatingUtil
     */
    @Autowired
    public RoutesController(RoutesRepository routesRepository, RoutePointsRepository routePointsRepository, CalculatingUtil calculatingUtil) {
        this.routesRepository = routesRepository;
        this.routePointsRepository = routePointsRepository;
        this.calculatingUtil = calculatingUtil;
    }

    /**
     * Метод получения всех маршрутов
     * @return лист маршрутов
     */
    @GetMapping("/getRoutesList")
    public List<Route> getRoutesList() {
        return (List<Route>) routesRepository.findAll();
    }

    /**
     * Метод получения маршрута по ид
     * @param routeId - ид маршрута
     * @return маршрут
     */
    @GetMapping("/getRoute")
    public Route getRoute(Long routeId) {
        return routesRepository.findOne(routeId);
    }

    /**
     * Метод создания маршрута по точкам
     * @param routePointsList - список точек маршрута
     * @return время на маршрут
     */
    @PostMapping("/addRoute")
    public long addRoute(List<Long> routePointsList) {
        Route route = new Route();
        List<RoutePoint> routePoints = (List<RoutePoint>) routePointsRepository.findAll(routePointsList);
        route.setPoints(routePoints);
        // TODO проверить
        //restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("routerHelper", "q1w2e3"));
        int time = restTemplate.getForObject(ROUTE_HELPERS_SERVICE_URL, Integer.class, routePoints);
        route.setTime(time);
        routesRepository.save(route);
        return route.getId();
    }
}
