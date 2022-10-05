package car.service;

import java.util.List;

public interface ParseService {
    void parseCarToStorage(List<String> lines);

    void saveCarToStorage(String car);
}
