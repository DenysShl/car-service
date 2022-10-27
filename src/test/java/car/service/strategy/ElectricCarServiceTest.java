package car.service.strategy;

import static org.junit.Assert.*;

import car.model.ElectricCar;
import car.model.enums.CarType;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Denys.ShD
 * @version v1.001 shd
 * @created 26.10.2022 - 15:29
 * @project car-service
 */
public class ElectricCarServiceTest {
    private static final String ELECTRIC_CAR = "ELECTRIC TesLA; Model S; 5.8; 220; 700; 100; 5";
    private static ElectricCarService electricCarService;

    @BeforeClass
    public static void beforeClass() throws Exception {
        electricCarService = new ElectricCarService();
    }

    @Test
    public void getElectricCar_Ok() {
        ElectricCar expected = new ElectricCar(CarType.ELECTRIC,
                "TESLA",
                "MODEL S",
                5.8,
                220,
                700,
                100,
                5);
        ElectricCar actual = (ElectricCar) electricCarService.getCar(ELECTRIC_CAR);
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getRange(), actual.getRange());
    }

}