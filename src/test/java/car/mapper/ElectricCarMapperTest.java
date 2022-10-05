package car.mapper;

import static org.junit.Assert.assertEquals;

import car.model.ElectricCar;
import car.model.enums.CarType;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElectricCarMapperTest {
    private static final String ELECTRIC_CAR = "ELECTRIC TESLA; Model S; 5.8; 220; 700; 100; 5";
    private static ElectricCarMapper electricCarMapper;

    @BeforeClass
    public static void beforeClass() throws Exception {
        electricCarMapper = new ElectricCarMapper();
    }

    @Test
    public void getElectricCar_Ok() {
        ElectricCar expected = new ElectricCar(CarType.ELECTRIC,
                "TESLA",
                "Model S",
                5.8,
                220,
                700,
                100,
                5);
        ElectricCar actual = electricCarMapper.apply(ELECTRIC_CAR);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getRange(), actual.getRange());
        assertEquals(expected, actual);
    }
}
