package car.model;

import car.model.enums.CarType;
import java.util.Objects;

public abstract class Car {
    protected CarType carType;
    protected String brand;
    protected String model;
    protected Double acceleration;
    protected Integer speed;

    public Car(CarType carType,
               String brand,
               String model,
               Double acceleration,
               Integer speed) {
        this.carType = carType;
        this.brand = brand;
        this.model = model;
        this.acceleration = acceleration;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return carType == car.carType
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && Objects.equals(acceleration, car.acceleration)
                && Objects.equals(speed, car.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carType, brand, model, acceleration, speed);
    }

    @Override
    public String toString() {
        return String.format("Car |%-12s |%-12s |%-10s |%-4.4s |%-5s",
                carType.getValue(), brand, model, acceleration, speed);
    }
}
