package car.model;

import car.model.enums.CarType;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pickup_car")
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

    public PickupCar() {

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
        final PickupCar that = (PickupCar) o;
        if (!Objects.equals(super.getModel(), that.getModel())) {
            return false;
        }
        if (!Objects.equals(super.getAcceleration(), that.getAcceleration())) {
            return false;
        }
        if (!Objects.equals(super.getBrand(), that.getBrand())) {
            return false;
        }
        if (!Objects.equals(super.getSpeed(), that.getSpeed())) {
            return false;
        }
        if (!Objects.equals(super.getCarType(), that.getCarType())) {
            return false;
        }
        return Objects.equals(fuelConsumption, that.fuelConsumption);
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
