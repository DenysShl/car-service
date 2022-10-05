package car.mapper;

import car.model.ElectricCar;
import car.model.enums.CarType;
import java.util.function.Function;

public class ElectricCarMapper implements Function<String, ElectricCar> {
    @Override
    public ElectricCar apply(String s) {
        String[] values = s.split(";");
        String[] brand = values[0].split(" ");
        return new ElectricCar(
                CarType.valueOf(brand[0]),
                brand[1].trim().toUpperCase(),
                values[1].trim(),
                Double.parseDouble(values[2].trim()),
                Integer.parseInt(values[3].trim()),
                Integer.parseInt(values[4].trim()),
                Integer.parseInt(values[5].trim()),
                Integer.parseInt(values[6].trim())
        );
    }
}
