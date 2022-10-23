package car.model.enums;

public enum CarType {
    ELECTRIC("Electric"),
    HIGH_SPEED("High-Speed"),
    PICKUP("Pickup");

    private String value;

    CarType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
