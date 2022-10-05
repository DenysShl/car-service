package car.service.impl;

import car.model.Car;
import car.service.GenerateReportsCarService;
import car.storage.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateReportsCarServiceImpl implements GenerateReportsCarService {
    @Override
    public List<Car> getAllCarsReport() {
        return Storage.cars;
    }

    @Override
    public List<Car> getAllCarsByBrand(String brand) {
        return Storage.cars.stream()
                .filter(car -> brand.toUpperCase().equals(car.getBrand().toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCarsByType(String type) {
        return Storage.cars.stream()
                .filter(car -> type.toUpperCase()
                        .replaceAll("-","_")
                        .equals(car.getCarType().name().toUpperCase()))
                .collect(Collectors.toList());
    }
}
