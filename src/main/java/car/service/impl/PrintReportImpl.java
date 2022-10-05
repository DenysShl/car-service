package car.service.impl;

import car.model.Car;
import car.service.PrintReport;
import java.util.List;

public class PrintReportImpl implements PrintReport {
    @Override
    public void print(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Can`t find cars, list is empty!");
        }
        cars.forEach(System.out::println);
    }
}
