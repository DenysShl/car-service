package car.model;

import car.model.enums.CarType;
import car.model.enums.DriverType;
import java.util.Objects;

public class HighSpeedCar extends Car {
    private DriverType driveType;
    private String gearBox;

    public HighSpeedCar(CarType carType,
                        String brand,
                        String model,
                        Double acceleration,
                        Integer speed,
                        DriverType driveType,
                        String gearBox) {
        super(carType, brand, model, acceleration, speed);
        this.driveType = driveType;
        this.gearBox = gearBox;
    }

    public DriverType getDriveType() {
        return driveType;
    }

    public void setDriveType(DriverType driveType) {
        this.driveType = driveType;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HighSpeedCar that = (HighSpeedCar) o;
        return driveType == that.driveType && Objects.equals(gearBox, that.gearBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driveType, gearBox);
    }

    @Override
    public String toString() {
        return String.format(super.toString()
                + "|%-12s |%-35s |", driveType.getValue(), gearBox);
    }
}
