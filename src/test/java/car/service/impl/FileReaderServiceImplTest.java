package car.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import car.service.FileReaderService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FileReaderServiceImplTest {
    private File testFile = new File("src/test/resources/testData.txt");
    private FileReaderService fileReaderService = new FileReaderServiceImpl();

    @Test
    public void readFromFile_Ok() throws RuntimeException {
        List<String> expected = new ArrayList<>();
        expected.add("HIGH-SPEED BMW; M5; 5.7; 380; AWD; 8-speed");
        expected.add("ELECTRIC TESLA; Model S; 5.8; 220; 700; 100; 5");
        expected.add("PICKUP Dodge; RAM 1500; 6.5; 210; 14.3");
        List<String> actual = fileReaderService.readFromFile(testFile.getPath());
        assertEquals(expected, actual);
        assertEquals(3, actual.size());
    }

    @Test
    public void readFromFile_notOk() {
        try {
            fileReaderService.readFromFile("notExistingFile.txt");
        } catch (RuntimeException e) {
            return;
        }
        fail("We should get an exception while trying to read data from not existent file.");
    }
}
