package car.mapper;

import static org.junit.Assert.assertEquals;

import car.model.HighSpeedCar;
import car.model.enums.CarType;
import car.model.enums.DriverType;
import org.junit.BeforeClass;
import org.junit.Test;

public class HighSpeedCarMapperTest {
    private static final String HIGH_SPEED_CAR = "HIGH-SPEED BMW; M5; 5.7; 380; AWD; 8-speed";
    private static HighSpeedCarMapper highSpeedCarMapper;

    @BeforeClass
    public static void beforeClass() throws Exception {
        highSpeedCarMapper = new HighSpeedCarMapper();
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
        HighSpeedCar actual = highSpeedCarMapper.apply(HIGH_SPEED_CAR);
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getAcceleration(), actual.getAcceleration());
    }
}
