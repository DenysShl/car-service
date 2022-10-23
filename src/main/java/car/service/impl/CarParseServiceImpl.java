package car.service.impl;

import car.mapper.ElectricCarMapper;
import car.mapper.HighSpeedCarMapper;
import car.mapper.PickupCarMapper;
import car.model.Car;
import car.model.enums.CarType;
import car.service.CarParseService;

public class CarParseServiceImpl implements CarParseService {
    public Car parseToCar(String string) {
        if (string.isEmpty()) {
            throw new RuntimeException("We can`t parse an empty string");
        }
        String[] values = string.split(";");
        String[] brendType = values[0].split(" ");
        String carType = brendType[0].replaceAll("-", "_").toUpperCase();

        switch (CarType.valueOf(carType)) {
            case HIGH_SPEED:
                return new HighSpeedCarMapper().apply(string);
            case ELECTRIC:
                return new ElectricCarMapper().apply(string);
            case PICKUP:
                return new PickupCarMapper().apply(string);

            default:
                throw new IllegalArgumentException("Unexpected value: " + carType);
        }
    }
}
