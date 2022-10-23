package car.service.impl;

import car.model.Car;
import car.service.ReportCarService;
import java.util.List;

public class ReportCarServiceImpl implements ReportCarService {
    @Override
    public void print(List<Car> cars) {
        try {
            if (cars == null || cars.isEmpty()) {
                System.out.println("Can`t find cars, list is empty!");
            } else {
                cars.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Can`t find cars, list is empty!");
        }
    }
}
