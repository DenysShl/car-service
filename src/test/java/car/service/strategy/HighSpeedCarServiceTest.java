package car.service.strategy;

import static org.junit.Assert.*;

import car.model.HighSpeedCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Denys.ShD
 * @version v1.001 shd
 * @created 26.10.2022 - 15:34
 * @project car-service
 */
public class HighSpeedCarServiceTest {
    private static final String HIGH_SPEED_CAR = "HIGH-SPEED BMW; M5; 5.7; 380; AWD; 8-speed";
    private static HighSpeedCarService highSpeedCarService;

    @BeforeClass
    public static void beforeClass() throws Exception {
        highSpeedCarService = new HighSpeedCarService();
    }

    @Test
    public void getHighSpeedCar_Ok() {
        HighSpeedCar expected = new HighSpeedCar(CarType.HIGH_SPEED,
                "BMW",
                "M5",
                5.7,
                380,
                DriverType.AWD,
                "8-speed");
        HighSpeedCar actual = (HighSpeedCar) highSpeedCarService.getCar(HIGH_SPEED_CAR);
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getAcceleration(), actual.getAcceleration());
    }

}