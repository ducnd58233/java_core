package service;

import java.util.List;

public interface BFileService<T> {
    void writeToFile (String path, List<T> list);

    List<T> readDataFromFile(String path);
}
