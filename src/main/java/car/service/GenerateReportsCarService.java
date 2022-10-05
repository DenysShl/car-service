package car.service;

import car.model.Car;
import java.util.List;

public interface GenerateReportsCarService {
    List<Car> getAllCarsReport();

    List<Car> getAllCarsByBrand(String brand);

    List<Car> getAllCarsByType(String type);
}
