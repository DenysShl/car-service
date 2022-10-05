package car.model.enums;

public enum CarType {
    HIGH_SPEED("High-Speed"),
    ELECTRIC("Electric"),
    PICKUP("Pickup");

    private String value;

    CarType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
