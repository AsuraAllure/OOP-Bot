package BotPackage.FunctionalTest;

import BotPackage.Interfaces.Reader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestReader implements Reader {
    private int counter;
    private String nameOfFile;

    public TestReader() {
        counter = 0;
    }

    @Override
    public void incrementCounter() {
        counter += 1;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    @Override
    public String read() {
        int i = counter;
        String line;
        Path path = Paths.get(nameOfFile);
        try {
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            line = allLines.get(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }
}
