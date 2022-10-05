package car.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import car.service.ParseService;
import car.storage.Storage;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Denys.Shl
 * @created 05.10.2022 - 12:29
 * @project car-service
 */
public class ParseServiceImplTest {
    private List<String> lines;
    private ParseService parseService;
    private String stringTest;

    @Before
    public void setUp() throws Exception {
        stringTest = "PICKUP Ford; F 150; 7.5; 210; 16.1";
        parseService = new ParseServiceImpl();
        lines = List.of(
                "HIGH-SPEED BMW; M5; 5.7; 380; AWD; 8-speed",
                "ELECTRIC TESLA; Model S; 5.8; 220; 700; 100; 5",
                "PICKUP Dodge; RAM 1500; 6.5; 210; 14.3",
                "PICKUP GMC; Sierra; 7.7; 205; 17.4",
                "HIGH-SPEED Lamborghini; Huracan; 3.4; 325; FWD; 7-speed automatic"
        );
    }

    @After
    public void afterTest() {
        Storage.cars.clear();
    }

    @Test
    public void parseCarToStorage_Ok() {
        parseService.saveCarToStorage(stringTest);
        assertEquals(1, Storage.cars.size());
    }

    @Test
    public void parseCarToStorage_notOk() {
        assertThrows(RuntimeException.class,
                () -> parseService.saveCarToStorage(""));
    }

    @Test
    public void parseCarToStorageNotFindCarType_notOk() {
        try {
            parseService.saveCarToStorage("TRUCK BMW; M5; 5.7; 380; AWD; 8-speed");
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("We should get an exception while creating car.");
}

    @Test
    public void saveCarToStorage_Ok() {
        parseService.parseCarToStorage(lines);
        assertEquals(5, Storage.cars.size());
    }
}
