package car.mapper;

import car.model.HighSpeedCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import java.util.function.Function;

public class HighSpeedCarMapper implements Function<String, HighSpeedCar> {
    @Override
    public HighSpeedCar apply(String s) {
        String[] values = s.split(";");
        String[] brand = values[0].split(" ");
        return new HighSpeedCar(
                CarType.valueOf(brand[0].replaceAll("-", "_")),
                brand[1].trim().toUpperCase(),
                values[1].trim().toUpperCase(),
                Double.parseDouble(values[2].trim()),
                Integer.parseInt(values[3].trim()),
                DriverType.valueOf(values[4].trim()),
                values[5].trim()
        );
    }
}
