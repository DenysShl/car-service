package car.service.impl;

import static org.junit.Assert.assertEquals;

import car.model.Car;
import car.model.ElectricCar;
import car.model.HighSpeedCar;
import car.model.PickupCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import car.service.GenerateReportsCarService;
import car.storage.Storage;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenerateReportsCarServiceImplTest {
    private GenerateReportsCarService generateReportsCarService
            = new GenerateReportsCarServiceImpl();
    private String brandTest = "BMW";
    private String typeCarTest = "High-Speed";
    private static List<Car> cars;

    @BeforeClass
    public static void beforeClass() throws Exception {
        cars = List.of(
                new ElectricCar(CarType.ELECTRIC,
                        "TESLA",
                        "Model S",
                        5.8,
                        220,
                        700,
                        100,
                        5),
                new HighSpeedCar(CarType.HIGH_SPEED,
                        "BMW",
                        "M5",
                        5.7,
                        380,
                        DriverType.AWD,
                        "8-speed"),
                new HighSpeedCar(CarType.HIGH_SPEED,
                        "Bugatti",
                        "Veyron",
                        2.7,
                        520,
                        DriverType.AWD,
                        "8-speed"),
                new PickupCar(CarType.PICKUP,
                        "WV",
                        "Amarok",
                        15.7,
                        240,
                        17.2)
        );
        Storage.cars.addAll(cars);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Storage.cars.removeAll(cars);
    }

    @Test
    public void getAllCarsReport_Ok() {
        List<Car> actual = generateReportsCarService.getAllCarsReport();
        assertEquals(cars.size(), actual.size());
        assertEquals(cars, actual);
    }

    @Test
    public void getAllCarsByBrand_Ok() {
        List<Car> actual = generateReportsCarService.getAllCarsByBrand(brandTest);
        assertEquals(1, actual.size());
    }

    @Test
    public void getAllCarsByNotFindBrand_Ok() {
        List<Car> actual = generateReportsCarService.getAllCarsByBrand("brandTest");
        assertEquals(0, actual.size());
    }

    @Test
    public void getAllCarsByType_Ok() {
        List<Car> actual = generateReportsCarService.getAllCarsByType(typeCarTest);
        assertEquals(2, actual.size());
    }

    @Test
    public void getAllCarsByNotFindType_Ok() {
        List<Car> actual = generateReportsCarService.getAllCarsByType("asd");
        assertEquals(0, actual.size());
    }
}
