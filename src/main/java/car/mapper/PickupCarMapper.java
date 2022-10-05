package car.mapper;

import car.model.PickupCar;
import car.model.enums.CarType;
import java.util.function.Function;

public class PickupCarMapper implements Function<String, PickupCar> {
    @Override
    public PickupCar apply(String s) {
        String[] values = s.split(";");
        String[] brand = values[0].split(" ");
        return new PickupCar(
                CarType.valueOf(brand[0]),
                brand[1].trim().toUpperCase(),
                values[1].trim(),
                Double.parseDouble(values[2].trim()),
                Integer.parseInt(values[3].trim()),
                Double.parseDouble(values[4].trim())
        );
    }
}
