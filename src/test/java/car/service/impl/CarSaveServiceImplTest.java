package car.service.impl;

import car.model.Car;
import car.model.PickupCar;
import car.model.enums.CarType;
import car.service.CarSaveService;
import car.storage.Storage;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarSaveServiceImplTest extends TestCase {
    private CarSaveService carSaveService;

    @Before
    public void setUp() throws Exception {
        carSaveService = new CarSaveServiceImpl();
    }

    @After
    public void afterTest() {
        Storage.cars.clear();
    }

    @Test
    public void testSaveCarToStorage_ValidSize_Ok() {
        carSaveService.saveCarToStorage(getCar());
        int actual = Storage.cars.size();
        assertEquals(1, actual);
    }

    @Test
    public void testSaveToStorage_Ok() {
        PickupCar expected = (PickupCar) getCar();
        carSaveService.saveCarToStorage(expected);
        PickupCar actual = (PickupCar) Storage.cars.stream().findFirst().get();
        assertEquals(expected, actual);
        assertEquals(expected.getCarType(), actual.getCarType());
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getFuelConsumption(), actual.getFuelConsumption());
    }

    private Car getCar() {
        return new PickupCar(
                CarType.PICKUP,
                "FORD",
                "F-150",
                6.5,
                180,
                14.8
        );
    }
}
