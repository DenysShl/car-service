package car.dao;

import car.model.Car;
import java.util.List;

public interface CarDao {
    Car save(Car car);

    List<Car> getAllCars();

    List<Car> getAllCarsByBrand(String brand);

    List<Car> getAllCarsByType(String type);
}
