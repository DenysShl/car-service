package car.model.enums;

public enum DriverType {
    AWD("All-wheel drive"),
    FWD("Front-Wheel Drive"),
    RWD("Rear-Wheel Drive");

    private String value;

    DriverType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
