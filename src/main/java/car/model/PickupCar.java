package car.model;

import car.model.enums.CarType;
import java.util.Objects;

public class PickupCar extends Car {
    private Double fuelConsumption;

    public PickupCar(CarType carType,
                     String brand,
                     String model,
                     Double acceleration,
                     Integer speed,
                     Double fuelConsumption) {
        super(carType, brand, model, acceleration, speed);
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PickupCar pickupCar = (PickupCar) o;
        return Objects.equals(fuelConsumption, pickupCar.fuelConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelConsumption);
    }

    @Override
    public String toString() {
        return String.format(super.toString()
                + "|%-6.2s |", fuelConsumption);
    }
}
