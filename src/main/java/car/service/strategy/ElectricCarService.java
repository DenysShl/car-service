package car.service.strategy;

import car.model.Car;
import car.model.ElectricCar;
import car.model.enums.CarType;
import car.service.CarCreateService;

public class ElectricCarService implements CarCreateService {
    @Override
    public Car getCar(String string) {
        String[] values = string.split(";");
        String[] brand = values[0].split(" ");
        return new ElectricCar(
                CarType.valueOf(brand[0]),
                brand[1].trim().toUpperCase(),
                values[1].trim().toUpperCase(),
                Double.parseDouble(values[2].trim()),
                Integer.parseInt(values[3].trim()),
                Integer.parseInt(values[4].trim()),
                Integer.parseInt(values[5].trim()),
                Integer.parseInt(values[6].trim())
        );
    }
}
