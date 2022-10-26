package car.model;

import car.model.enums.CarType;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "car_type")
    private CarType carType;
    @Column(nullable = false)
    private String brand;
    private String model;
    private Double acceleration;
    private Integer speed;

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

    public Car() {

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
