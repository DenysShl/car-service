package car.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import car.model.Car;
import car.model.ElectricCar;
import car.model.HighSpeedCar;
import car.model.PickupCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import car.service.CarCreateService;
import org.junit.Before;
import org.junit.Test;

public class CarStrategyTest {
    private CarStrategy carStrategy;
    private static final String ELECTRIC_CAR = "ELECTRIC TesLA; model s; 5.8; 220; 700; 100; 5";
    private static final String HIGHSPEED_CAR = "HIGH-SPEED BMW; M5; 5.7; 380; AWD; 8-speed";
    private static final String PICKUP_CAR = "PICKUP WV; AmaroK; 15.7; 210; 17.2";
    private static final String CAR_TYPE_IS_NOT_EXIST = "CARTYPE WV; AmaroK; 15.7; 210; 17.2";
    private static Car electricCar;
    private static Car highSpeedCar;
    private static Car highSpeedCarTwo;
    private static Car pickupCar;

    @Before
    public void setUp() {
        carStrategy = new CarStrategy();

        electricCar = new ElectricCar(
                CarType.ELECTRIC,
                "TESLA",
                "MODEL S",
                5.8,
                220,
                700,
                100,
                5
        );
        highSpeedCar = new HighSpeedCar(
                CarType.HIGH_SPEED,
                "BMW",
                "M5",
                5.7,
                380,
                DriverType.AWD,
                "8-speed"
        );
        pickupCar = new PickupCar(
                CarType.PICKUP,
                "WV",
                "AMAROK",
                15.7,
                210,
                17.2
        );
    }

    @Test
    public void getCarCreateService_StringIsEmpty_notOk() {
        assertThrows(RuntimeException.class,
                () -> carStrategy.getCarCreateService(""));
    }

    @Test
    public void getCarCreateService_CarTypeIsNotExist_notOk() {
        try {
            carStrategy.getCarCreateService(CAR_TYPE_IS_NOT_EXIST);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("CarType is not exist");
    }

    @Test
    public void getCarCreateService_CarType_notOk() {
        assertThrows(IllegalArgumentException.class,
                () -> carStrategy.getCarCreateService(CAR_TYPE_IS_NOT_EXIST)
                        .getCar(CAR_TYPE_IS_NOT_EXIST));
    }

    @Test
    public void getCarCreateService_getElectricCar_Ok() {
        Car actual = carStrategy.getCarCreateService(ELECTRIC_CAR).getCar(ELECTRIC_CAR);
        assertNotNull(actual);
        assertEquals(electricCar, actual);
    }

    @Test
    public void getCarCreateService_getPickupCar_Ok() {
        Car actual = carStrategy.getCarCreateService(PICKUP_CAR).getCar(PICKUP_CAR);
        assertNotNull(actual);
        assertEquals(pickupCar, actual);
    }

    @Test
    public void getCarCreateService_getHighSpeedCar_Ok() {
        Car actual = carStrategy.getCarCreateService(HIGHSPEED_CAR).getCar(HIGHSPEED_CAR);
        assertNotNull(actual);
        assertEquals(highSpeedCar, actual);
    }
}