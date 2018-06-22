package ru.mg.microservices.routehelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mg.microservices.entity.RoutePoint;
import ru.mg.microservices.repository.RoutePointGraphRepository;
import ru.mg.microservices.utils.CalculatingUtil;

import java.util.List;
import java.util.logging.Logger;

/**
 * Контроллер для сервиса-хелпера(калькулятора)
 * CrossOrigin для кроссдоменных запросов
 */
@CrossOrigin
@RestController
public class RouteHelperController {
    private Logger logger = Logger.getLogger(RouteHelperController.class.getName());
    private RoutePointGraphRepository routePointGraphRepository;

    /**
     * Утилитарный бин для расчета времени на маршрут
     */
    private CalculatingUtil calculatingUtil;

    /**
     * Конструктор с DI
     * @param routePointGraphRepository
     * @param calculatingUtil
     */
    @Autowired
    public RouteHelperController(RoutePointGraphRepository routePointGraphRepository, CalculatingUtil calculatingUtil) {
        this.routePointGraphRepository = routePointGraphRepository;
        this.calculatingUtil = calculatingUtil;
    }

    /**
     * Метод считающий время на маршрут
     * @param pointsList список точек
     * @return time
     */
    @GetMapping("/getTimeForRoute")
    public Integer getTimeForRoute(List<RoutePoint> pointsList) {
        Integer time = calculatingUtil.calculateRouteTime(pointsList);
        logger.info("CalculatedTime:" + time);
        return time < 0 ? time : -1;
    }
}
