package ru.mg.microservices.services;

import ru.mg.microservices.services.routes.RoutesServer;
import ru.mg.microservices.services.routeheplers.RouteHelperServer;

public class Main {

    public static void main(String[] args) {

        String serverName = args[0].toLowerCase();

        switch (serverName) {
            case "routeheplers":
                RouteHelperServer.main(args);
                break;
            case "routes":
                RoutesServer.main(args);
                break;
            default:
                System.out.println("Unknown server type: " + serverName);
                break;
        }
    }
}
