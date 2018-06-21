package ru.mg.microservices.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mg.microservices.entity.RoutePoint;
import ru.mg.microservices.entity.RoutePointGraph;
import ru.mg.microservices.repository.RoutePointGraphRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatingUtil {

    private RoutePointGraphRepository routePointGraphRepository;

    @Autowired
    public CalculatingUtil(RoutePointGraphRepository routePointGraphRepository) {
        this.routePointGraphRepository = routePointGraphRepository;
    }

    public Integer calculateRouteTime(List<RoutePoint> points) {
        List<RoutePointGraph> routePointGraphs = (List<RoutePointGraph>) routePointGraphRepository.findAll();
        List<RoutePointGraph> filteredGraph = new ArrayList<>();
        for (RoutePoint r : points) {
            RoutePointGraph graph = routePointGraphs.stream().filter(g -> g.getFirstPoint().getId() == r.getId()).findFirst().get();
            filteredGraph.add(graph);
            for (RoutePoint point : points) {
                if (point.getId() == graph.getSecondPoint().getId()) {
                    points.remove(point);
                }
            }
        }

        return filteredGraph.stream().mapToInt(RoutePointGraph::getTime).sum();
    }
}
