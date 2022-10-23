package car.mapper;

import static org.junit.Assert.assertEquals;

import car.model.PickupCar;
import car.model.enums.CarType;
import org.junit.BeforeClass;
import org.junit.Test;

public class PickupCarMapperTest {
    private static final String PICKUP_CAR = "PICKUP wv; Amarok; 15.7; 240; 17.2";
    private static PickupCarMapper pickupCarMapper;

    @BeforeClass
    public static void beforeClass() throws Exception {
        pickupCarMapper = new PickupCarMapper();
    }

    @Test
    public void getPickupCar_Ok() {
        PickupCar expected = new PickupCar(
                CarType.PICKUP,
                "WV",
                "AMAROK",
                15.7,
                240,
                17.2);
        PickupCar actual = pickupCarMapper.apply(PICKUP_CAR);
        assertEquals(expected, actual);
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getFuelConsumption(), actual.getFuelConsumption());
    }
}
