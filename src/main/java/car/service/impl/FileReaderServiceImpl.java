package car.service.impl;

import car.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println(("File does not exist: " + fileName));
            throw new RuntimeException("File does not exist: " + fileName, e);
        }
    }
}
