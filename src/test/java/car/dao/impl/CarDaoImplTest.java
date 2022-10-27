package car.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import car.dao.CarDao;
import car.model.Car;
import car.model.ElectricCar;
import car.model.HighSpeedCar;
import car.model.PickupCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import car.util.HibernateUtil;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

public class CarDaoImplTest {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static CarDao carDao = new CarDaoImpl(sessionFactory);
    private String brandTest = "BMW";
    private String typeCarTest = "High-Speed";
    private static List<Car> cars;
    private static List<Car> carsNotSorted;
    private static Car electricCar;
    private static Car highSpeedCar;
    private static Car highSpeedCarTwo;
    private static Car pickupCar;

    @BeforeClass
    public static void beforeClass() throws Exception {
        electricCar = new ElectricCar(
                CarType.ELECTRIC,
                "TESLA",
                "Model S",
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
        highSpeedCarTwo = new HighSpeedCar(
                CarType.HIGH_SPEED,
                "Bugatti",
                "Veyron",
                2.7,
                520,
                DriverType.AWD,
                "8-speed"
        );
        pickupCar = new PickupCar(
                CarType.PICKUP,
                "WV",
                "Amarok",
                15.7,
                240,
                17.2
        );
        cars = List.of(electricCar, highSpeedCar, pickupCar);
        carsNotSorted = List.of(pickupCar, electricCar, highSpeedCar);
        carDao.save(electricCar);
        carDao.save(highSpeedCar);
        carDao.save(pickupCar);
    }

    @Test
    public void save_Ok() {
        Car highSpeedCarTest = new HighSpeedCar(
                CarType.HIGH_SPEED,
                "Bugatti",
                "Veyron",
                2.7,
                520,
                DriverType.AWD,
                "8-speed"
        );
        Car actual = carDao.save(highSpeedCarTest);
        assertEquals(highSpeedCarTest, actual);
    }

    @Test
    public void save_notOk() {
        assertThrows(RuntimeException.class, () -> {
            carDao.save(new Car());
        });
    }

    @Test
    public void getAllCars_Ok() {
        List<Car> actual = carDao.getAllCars();
        assertNotNull(actual);
        assertEquals(cars, actual);
        assertEquals(cars.size(), actual.size());
    }

    @Test
    public void getAllCarsByBrand_Ok() {
        List<Car> actual = carDao.getAllCarsByBrand(brandTest);
        assertNotNull(actual);
        assertEquals(List.of(highSpeedCar), actual);
        assertEquals(1, actual.size());
    }

    @Test
    public void getAllCarsByNotFindBrand_Ok() {
        List<Car> actual = carDao.getAllCarsByBrand("brandTest");
        assertEquals(0, actual.size());
    }

    @Test
    public void getAllCarsByType_Ok() {
        List<Car> actual = carDao.getAllCarsByType(typeCarTest);
        assertEquals(List.of(highSpeedCar), actual);
        assertEquals(1, actual.size());
    }

    @Test
    public void getAllCarsByNotFindType_notOk() {
        assertThrows(RuntimeException.class, () -> {
            carDao.getAllCarsByType("asd");
        });
    }
}