package car.model;

import car.model.enums.CarType;
import java.util.Objects;

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
        ElectricCar that = (ElectricCar) o;
        return Objects.equals(range, that.range)
                && Objects.equals(batteryCapacity, that.batteryCapacity)
                && Objects.equals(warranty, that.warranty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(range, batteryCapacity, warranty);
    }

    @Override
    public String toString() {
        return String.format(super.toString()
                + "|%-5s |%-5s |%-4s |", range, batteryCapacity, warranty);
    }
}
