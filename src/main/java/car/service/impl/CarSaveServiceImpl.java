package car.service.impl;

import car.model.Car;
import car.service.CarSaveService;
import car.storage.Storage;

public class CarSaveServiceImpl implements CarSaveService {
    @Override
    public void saveCarToStorage(Car car) {
        Storage.cars.add(car);
    }
}
