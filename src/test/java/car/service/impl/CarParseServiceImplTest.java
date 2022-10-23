package car.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import car.model.Car;
import car.model.ElectricCar;
import car.model.HighSpeedCar;
import car.model.PickupCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import car.service.CarParseService;
import org.junit.Before;
import org.junit.Test;

public class CarParseServiceImplTest {
    private CarParseService carParseService;
    private String stringTestCarElectrical;
    private String stringTestCarHighSpeed;
    private String stringTestCarPickup;

    @Before
    public void setUp() {
        stringTestCarHighSpeed = "HIGH-SPEED bmW; M5; 5.7; 380; AWD; 8-speed";
        stringTestCarElectrical = "ELECTRIC TeSlA; Model S; 5.8; 220; 700; 100; 5";
        stringTestCarPickup = "PICKUP Dodge; rAm 1500; 6.5; 210; 14.3";
        carParseService = new CarParseServiceImpl();
    }

    @Test
    public void parseToElectricalCar_Ok() {
        ElectricCar actual = (ElectricCar) carParseService.parseToCar(stringTestCarElectrical);
        ElectricCar expected = (ElectricCar) getElectricalCar();
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getSpeed(), actual.getSpeed());
        assertEquals(expected.getCarType(), actual.getCarType());
        assertEquals(expected.getWarranty(), actual.getWarranty());
    }

    @Test
    public void parseToHighSpeedCar_Ok() {
        HighSpeedCar actual = (HighSpeedCar) carParseService.parseToCar(stringTestCarHighSpeed);
        HighSpeedCar expected = (HighSpeedCar) getHighSpeedCar();
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getSpeed(), actual.getSpeed());
        assertEquals(expected.getCarType(), actual.getCarType());
        assertEquals(expected.getGearBox(), actual.getGearBox());
    }

    @Test
    public void parseToPickupCar_Ok() {
        PickupCar actual = (PickupCar) carParseService.parseToCar(stringTestCarPickup);
        PickupCar expected = (PickupCar) getPickupCar();
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getSpeed(), actual.getSpeed());
        assertEquals(expected.getCarType(), actual.getCarType());
        assertEquals(expected.getFuelConsumption(), actual.getFuelConsumption());
    }

    @Test
    public void parseCarToStorage_notOk() {
        assertThrows(RuntimeException.class,
                () -> carParseService.parseToCar(""));
    }

    @Test
    public void parseCarToStorageNotFindCarType_notOk() {
        try {
            carParseService.parseToCar("TRUCK BMW; M5; 5.7; 380; AWD; 8-speed");
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("We should get an exception while creating car.");
    }

    private Car getElectricalCar() {
        return new ElectricCar(
                CarType.ELECTRIC,
                "TESLA",
                "MODEL S",
                5.8,
                220,
                700,
                100,
                5
        );
    }

    private Car getHighSpeedCar() {
        return new HighSpeedCar(
                CarType.HIGH_SPEED,
                "BMW",
                "M5",
                5.7,
                380,
                DriverType.AWD,
                "8-speed"
        );
    }

    private Car getPickupCar() {
        return new PickupCar(
                CarType.PICKUP,
                "DODGE",
                "RAM 1500",
                6.5,
                210,
                14.3
        );
    }
}
