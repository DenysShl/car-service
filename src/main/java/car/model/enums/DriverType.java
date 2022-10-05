package car.model.enums;

public enum DriverType {
    FWD("Front-Wheel Drive"),
    RWD("Rear-Wheel Drive"),
    AWD("All-wheel drive");

    private String value;

    DriverType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
