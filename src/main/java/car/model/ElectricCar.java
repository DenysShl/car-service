package car.model;

import car.model.enums.CarType;
import java.util.Objects;
import javax.persistence.Entity;

@Entity
public class ElectricCar extends Car {
    private Integer range;
    private Integer batteryCapacity;
    private Integer warranty;

    public ElectricCar(CarType carType,
                       String brand,
                       String model,
                       Double acceleration,
                       Integer speed,
                       Integer range,
                       Integer batteryCapacity,
                       Integer warranty) {
        super(carType, brand, model, acceleration, speed);
        this.range = range;
        this.batteryCapacity = batteryCapacity;
        this.warranty = warranty;
    }

    public ElectricCar() {

    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final ElectricCar that = (ElectricCar) o;
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
        if (!Objects.equals(range, that.range)) {
            return false;
        }
        if (!Objects.equals(batteryCapacity, that.batteryCapacity)) {
            return false;
        }
        return Objects.equals(warranty, that.warranty);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (range != null ? range.hashCode() : 0);
        result = 31 * result + (batteryCapacity != null ? batteryCapacity.hashCode() : 0);
        result = 31 * result + (warranty != null ? warranty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(super.toString()
                + "|%-5s |%-5s |%-4s |", range, batteryCapacity, warranty);
    }
}
