package car.service.impl;

import car.model.enums.CarType;
import car.service.CarCreateService;
import car.service.strategy.ElectricCarService;
import car.service.strategy.HighSpeedCarService;
import car.service.strategy.PickupCarService;

public class CarStrategy {
    public CarCreateService getCarCreateService(String string) {
        if (string.isEmpty()) {
            throw new RuntimeException("We can`t parse an empty string");
        }
        String[] values = string.split(";");
        String[] brendType = values[0].split(" ");
        String carType = brendType[0].replaceAll("-", "_").toUpperCase();

        return switch (CarType.valueOf(carType)) {
            case HIGH_SPEED -> new HighSpeedCarService();
            case ELECTRIC -> new ElectricCarService();
            case PICKUP -> new PickupCarService();
            default -> throw new IllegalArgumentException("Unexpected value: " + carType);
        };
    }
}
