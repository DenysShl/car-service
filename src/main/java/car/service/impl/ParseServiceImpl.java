package car.service.impl;

import car.mapper.ElectricCarMapper;
import car.mapper.HighSpeedCarMapper;
import car.mapper.PickupCarMapper;
import car.model.Car;
import car.model.enums.CarType;
import car.service.ParseService;
import car.storage.Storage;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    @Override
    public void parseCarToStorage(List<String> lines) {
        for (String stringCar : lines) {
            Storage.cars.add(getParsed(stringCar));
        }
    }

    private Car getParsed(String string) {
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

    @Override
    public void saveCarToStorage(String car) {
        Storage.cars.add(getParsed(car));
    }
}
